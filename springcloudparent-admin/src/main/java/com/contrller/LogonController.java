package com.contrller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.UserService;
import com.util.PageUtils;

@Controller
@RequestMapping("/admin")
public class LogonController {
	@Autowired 
	private UserService userService;

	@RequestMapping("/logon")
	@ResponseBody
	public String  videolist(HttpServletRequest request,String name,String passwd) {
		HttpSession session = request.getSession();
		//ModelAndView mav = new ModelAndView();
		Admin log=userService.findAdminByname(name);
		String msg;
		//List<String> list =new ArrayList<String>();
		if(log!=null) {
		if(log.getApasswd().equals(passwd) ) {
			session.setAttribute("name", name);
			session.setAttribute("passwd", passwd);
			msg="<script>alert('登录成功');top.window.location='main'"+"</script>";
		}else {
			
			msg="<script>alert('用户的密码输入错误');top.window.location='/admin/adlogon'"+"</script>";
		
		}}else {
			
			msg="<script>alert('用户名不存在');top.window.location='/admin/adlogon'"+"</script>";
		}
		return msg;
}
	//登出
	@RequestMapping("/logout")
	public ModelAndView  logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		session.removeAttribute("name");
		session.removeAttribute("passwd");
	    mav.setViewName("redirect:/admin/adlogon");
	    
		return mav;
}
	
	@RequestMapping("/add")
	@ResponseBody
	public String  add(HttpServletRequest request,String name,String passwd){
		//ModelAndView mav = new ModelAndView();
		String msg;
		if(userService.findAdminByname(name)!=null || name=="") {
			//mav.setViewName("addad");
			msg="<script>alert('注册的用户名已存在或用户名为空，请从新输入');;window.location='/admin/addad'"+"</script>";
			//mav.addObject("msg", msg);
		}else if(passwd==null || passwd=="" ){
			msg="<script>alert('密码不能为空');window.location='/admin/addad'"+"</script>";
		}else{
			//mav.setViewName("addad");
			userService.insrtAdminByname(name, passwd);
			msg="<script>alert('注册成功');window.location='/admin/addad'"+"</script>";
			//mav.addObject("msg", msg);
		}
		return msg;
}
	//删除管理员
		@RequestMapping("/delad")
		@ResponseBody
		public String  delad(HttpServletRequest request,String aname){
			String msg;
			HttpSession session = request.getSession(false);
		
			String name=(String)session.getAttribute("name");
			if(aname.equals("admin")) {
				msg="<script>alert('此管理员用户不可删除');window.location='/admin/adlists'</script>";
			}else if(aname.equals(name)){
				msg="<script>alert('当前用户不可删除');window.location='/admin/adlists'</script>";
			}else {
				userService.deladmin(aname);
				msg="<script>alert('管理员账号删除成功');window.location='/admin/adlists'</script>";	
			}
			return msg;
	}
		
	
	@RequestMapping("/updatepasswd")
	@ResponseBody
	public String  updatepasswd(HttpServletRequest request,
			String passwd,String passwd1,String passwd2){
		//String mav = new ModelAndView();
		String msg;
		HttpSession session = request.getSession(false);
		String name=(String)session.getAttribute("name");
		String password=(String)session.getAttribute("passwd");
		if(password.equals(passwd)) {
			if(passwd1.equals(passwd2)) {
			userService.updateAdminPasswd(name, passwd1);
			//mav.setViewName("updatepasswd");
			msg="<script>alert('密码修改成功');parent.window.location='/admin/adlogon'</script>";
			}else {
			//mav.setViewName("updatepasswd");
			msg="<script>alert('两次输入的密码不一致，请重新输入');'window.location='/admin/updatepasswd'</script>";
			}
		}else {
		//mav.setViewName("updatepasswd");
		msg="<script>alert('输入的原始密码不匹配,请重新输入');'window.location='/admin/updatepasswd'</script>";
		}
		//mav.addObject("msg", msg);
		return msg;
}
	
	
	//全部管理员
	@RequestMapping("/adlists")
	//@ResponseBody
	public ModelAndView  adlists(HttpServletRequest request,String name,Integer pageNo){
		ModelAndView mav = new ModelAndView();
		//初始化
		if(name==null) {name="";}
		Integer newpage=0;
		if(pageNo!=null) {	newpage=pageNo; }
		//分页准备
		PageUtils<Admin> page=new PageUtils<>(newpage,5);
		List<Admin> adlist=userService.Adminsearch(name);
		//分页
		page.doPage(adlist);
        	mav.setViewName("adlsit");
        	mav.addObject("adlist",page.getResults());
        	mav.addObject("totalPage",page.getTotalPage());
        	mav.addObject("pageNo",newpage);
        	mav.addObject("condition",name);
		return mav;
}
	///////////
	
	@RequestMapping("/test1")
	public ModelAndView  test1(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test1");
//		String pjtPath = request.getSession().getServletContext().getRealPath("/");
//		mav.addObject( "pjtPath",pjtPath);
		return mav;
		}
	@RequestMapping("/test")
	@ResponseBody
	public PageUtils test(HttpServletRequest request,String name,Integer pageNo){
		if(name==null) {name="";}
		if(pageNo==null) {	pageNo=0; }
		//分页准备
		PageUtils<Admin> page=new PageUtils<>(pageNo,5);
		List<Admin> adlist=userService.Adminsearch(name);
		//分页
		page.doPage(adlist);

		//1、使用JSONObject
		//JSONObject  json = JSONObject.fromObject(page);

        	//2、使用JSONArray
        	//JSONArray array=JSONArray.fromObject(stu);
		
		//String strpage=json.toString();
		return page;
	}
	
/////////////////////////////////////////////////////////////
	
	
	//修改密码管理员
			@RequestMapping("/adlsit")
			public ModelAndView  adlsit(HttpServletRequest request){
				ModelAndView mav = new ModelAndView();
				mav.setViewName("adlsit");
				return mav;
		}
	
	//修改密码管理员
		@RequestMapping("/uppasswd")
		public ModelAndView  uppasswd(HttpServletRequest request){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("updatepasswd");
			return mav;
	}
	
	//添加管理员
		@RequestMapping("/addad")
		public ModelAndView  addad(HttpServletRequest request){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("addad");
			return mav;
	}
	
	//主界面
		@RequestMapping("/main")
	public ModelAndView  main(HttpServletRequest request){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("index1");
			return mav;
		}
	
	//登录
	
	@RequestMapping("/adlogon")
	public ModelAndView  adlogon(HttpServletRequest request){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logon");
		//return "logon";
		return mav;
	}
//	@RequestMapping("/top")
//	public ModelAndView  top(HttpServletRequest request){
//		ModelAndView mav = new ModelAndView();	
//		mav.setViewName("Top");
//		return mav;
//}
//	@RequestMapping("/left")
//	public ModelAndView  left(HttpServletRequest request){
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("Left_nav");
//		return mav;
//}
	@RequestMapping("/contain")
	@ResponseBody
	public String  contain(HttpServletRequest request){
		return "hellow";
}
}
