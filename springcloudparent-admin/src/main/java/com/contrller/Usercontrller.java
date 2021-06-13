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
public class Usercontrller {
	@Autowired 
	private UserService userService;
	@RequestMapping("/userAndviewlist")
	public ModelAndView  userinfo(HttpServletRequest request, Integer pageNo,String uname) {
		Integer newpage=0;
		if(pageNo!=null) {	newpage=pageNo; }
		//String newuname="";
		if(uname==null) {uname="";}
		PageUtils<Video> page=new PageUtils<>(newpage,5);
		List<Video> userifo = userService.userAndviewlist(uname);
		ModelAndView mav = new ModelAndView();
		page.doPage(userifo);
		
        	mav.setViewName("userAndviewlist");
        	mav.addObject("userifo",page.getResults());
        	mav.addObject("totalPage",page.getTotalPage());
        	mav.addObject("pageNo",newpage);
        	mav.addObject("condition",uname);
     
		return mav;
}
	//user的信息list
	@RequestMapping("/usersearch")
	public ModelAndView  usersearch(HttpServletRequest request,String uname ,Integer pageNo,String status) {
		
		Integer newpage=0;
		if(uname==null) {uname="";}
		List<User> userifo = userService.findusrByname(uname,status);
		if(pageNo!=null) {	newpage=pageNo; }
		PageUtils<User> page=new PageUtils<>(newpage,5);
		page.doPage(userifo);
	    ModelAndView mav = new ModelAndView();
	    	mav.setViewName("index");
	 		mav.addObject("userifo",page.getResults());
        	mav.addObject("totalPage",page.getTotalPage());
        	mav.addObject("pageNo",newpage);
        	mav.addObject("status",status);
        	mav.addObject("uname",uname);
	
		return mav;
}
	//修改权限
	@RequestMapping("/update")
	public ModelAndView  update(HttpServletRequest request,User userifo) {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("update");
		mav.addObject("u",userifo);
		return mav;
}
	@RequestMapping("/updateuser")
	@ResponseBody
	public String  updateuser(HttpServletRequest request,
			Integer status,String uname) {
		//ModelAndView mav = new ModelAndView();
		userService.updateuser(status, uname);
		//mav.setViewName("update");
		//mav.addObject("hh","<script>alert('修改成功');window.location='/user/usersearch'</script>");
		String msg="<script>alert('修改成功');window.location='/admin/usersearch'</script>";
		return msg;
}
	//公告搜索功能
	@RequestMapping("/searchnotice")
	public ModelAndView searchnotice(String manage,String name,Integer pageNo,Integer status) {
		 ModelAndView mav = new ModelAndView("notice");
		 //String Tname="";
		 if(name==null) {name="";}
		 Integer newpage=0;
		 if(pageNo!=null) {	newpage=pageNo; }
		 if(status==null) {status=0;}
		 PageUtils<Teams> page=new PageUtils<>(newpage,5);
		 List<Teams> gonggao;
		 
		 if(manage.equals("admin")) {
			 gonggao=userService.gonggao2("admin", name,0);
			 mav.setViewName("notice");
		 }else {
			 gonggao=userService.gonggao2("user", name,status);
			 mav.setViewName("jubao");
			 mav.addObject("status",status);
	     	 mav.addObject("name",name);
		 }
		 page.doPage(gonggao);
		 mav.addObject("gonggao",page.getResults());
     	 mav.addObject("totalPage",page.getTotalPage());
     	 mav.addObject("pageNo",newpage);
		return mav;
	}
	
	//公告删除功能
	@RequestMapping("/delnotice")
	public ModelAndView delnotice(Integer id) {
		 ModelAndView mav = new ModelAndView();
		
		 userService.gonggao3(id);
		 mav.setViewName("redirect:/admin/searchnotice");
		 mav.addObject("manage","admin");
		return mav;
	}
	//公告发布功能
	@RequestMapping("/addnotice")
	public ModelAndView addnotice(String title,String name,String detail) {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("adnotice");
		return mav;
	}
	
	@RequestMapping("/addnotices")
	public ModelAndView addnotices(HttpServletRequest request,String title,String name,String detail) {
		 ModelAndView mav = new ModelAndView();
		 HttpSession session = request.getSession(false);
		 String oper=(String)session.getAttribute("name");
		userService.gonggao4(detail, title,name,oper);
		 mav.setViewName("redirect:/admin/searchnotice");
		 mav.addObject("manage","admin");
		return mav;
	}
	//公告查看功能
	@RequestMapping("/detailnotice")
	public ModelAndView detailnotice(Integer id) {
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("ggdetail");
		 mav.addObject("gg",userService.gonggao1(id));
		return mav;
	}
	
	@RequestMapping("/sqxg")
	@ResponseBody
	public String sqxg(Integer id,Integer status) {
		String msg="申请标记已更改";
		try {
		Integer sq=userService.gonggao5(id, status);
		}catch (Exception e) {
			msg="出现异常，请重试";
		}	 
		
		return msg;
	}
	
	
	
}
