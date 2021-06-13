package com.contrller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.UserService;
import com.util.PageUtils;
@Controller
@RequestMapping("/user")
public class Usercontrller {
	//
	@Autowired 
	private UserService userService;
	
	//单个用户列表
	@RequestMapping("/userOfviewlist")
	public ModelAndView userinfo(HttpServletRequest request, Integer pageNo,String uname,String status) {
		ModelAndView mav = new ModelAndView();
		//Integer newpage=0;
		if(pageNo==null) {	pageNo=0; }
		if(uname==null) {	uname=""; }
		PageUtils<Video> page=new PageUtils<>(pageNo,5);						
		HttpSession session = request.getSession(false);
        	String newuname=(String)session.getAttribute("name");
        	User userifo = userService.userOfviewlist(newuname,status);
        	List<Video> videolist;
        	try {
        		videolist=userifo.getVideo();
        	}catch(Exception e) {
        		videolist=new ArrayList<Video>();
        	}	

        	
        List<Video> copylist = new ArrayList<Video>();
      	for(int i=0;i<videolist.size();i++) {
       		if( (videolist.get(i).getVname().indexOf(uname))>-1) {
       			//videolist.remove(i);
       			copylist.add(videolist.get(i));
       		}
      	}
      	page.doPage(copylist);
		if(status.equals("1")) {
			mav.setViewName("userloadinfo");
		}else {
			mav.setViewName("videoup");
		}
		mav.addObject("userifo",page.getResults());
		mav.addObject("totalPage",page.getTotalPage());
		mav.addObject("pageNo",pageNo);
		mav.addObject("status", status);
		mav.addObject("uname", uname);
		return mav;
}
	
	//修改密码
		@RequestMapping("/uppasswd")
		public ModelAndView  uppasswd(HttpServletRequest request){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userpasswd");
			return mav;
	}
		@RequestMapping("/updatepasswd")
		public ModelAndView  updatepasswd(HttpServletRequest request,
				String passwd,String passwd1,String passwd2){
			ModelAndView mav = new ModelAndView();
			String msg;
			HttpSession session = request.getSession(false);
			String name=(String)session.getAttribute("name");
			String password=(String)session.getAttribute("passwd");
			if(password.equals(passwd)) {
				if(passwd1.equals(passwd2)) {
				userService.updateUserPasswd(name, passwd1);
				mav.setViewName("userpasswd");
				msg="<script>alert('密码修改成功');parent.window.location='/user/logout'</script>";
				}else {
				mav.setViewName("userpasswd");
				msg="<script>alert('两次输入的密码不一致，请重新输入');</script>";
				}
			}else {
			mav.setViewName("userpasswd");
			msg="<script>alert('输入的原始密码不匹配,请重新输入');</script>";
			}
			mav.addObject("msg", msg);
			return mav;
	}
		
	//下架视频
	@RequestMapping("/userdel")
	public ModelAndView  userdel(HttpServletRequest request,Integer vid){
			ModelAndView mav = new ModelAndView();
			Integer status=2;
			userService.userdel(vid, status);
			mav.setViewName("redirect:/user/userOfviewlist?status=1");
			//mav.addObject("status", 1);
			return mav;
	}
	//上架视频
		@RequestMapping("/userundel")
		public ModelAndView  userundel(HttpServletRequest request,Integer vid){
				ModelAndView mav = new ModelAndView();
				Integer status=1;
				userService.userdel(vid, status);
				mav.setViewName("redirect:/user/userOfviewlist?status=2");
				//mav.addObject("status", 2);
				return mav;
		}
	
	@RequestMapping("/userup")
	public ModelAndView  userup(HttpServletRequest request,Integer vid){
			ModelAndView mav = new ModelAndView();
			Integer status=1;
			userService.userdel(vid, status);			
			mav.setViewName("redirect:/user/userOfviewlist");
			mav.addObject("status", status);
			return mav;
	}
	
	//用户统计信息
	@RequestMapping("/usernumberrecord")
	public ModelAndView usernumberrecord(HttpServletRequest request,Integer pageNo) {
		ModelAndView mv=new ModelAndView();
		HttpSession session = request.getSession(false);
		String vuname=(String)session.getAttribute("name");
		//Integer upnb=userService.uploadnumber(vuname);
		PageUtils<Video> page=new PageUtils<>(pageNo,5);
		List<Video> obj=userService.uservideonumer();
		page.doPage(obj);
		mv.setViewName("udisplay");
		mv.addObject("likenb",userService.userOpernb(vuname,1));
		mv.addObject("collenb",userService.userOpernb(vuname,2));
		mv.addObject("upnb",userService.uploadnumber(vuname));
		mv.addObject("obj",page.getResults());
		mv.addObject("totalPage",page.getTotalPage());
    	mv.addObject("pageNo",pageNo);
		return mv;
	}
	
	// 用户公告
	@RequestMapping("/usernotice")
	public ModelAndView usernotice(Integer pageNo) {
		ModelAndView mv=new ModelAndView();
		PageUtils<Teams> page=new PageUtils<>(pageNo,5);
		List<Teams>list=userService.info("admin","",0);
		page.doPage(list);
		mv.setViewName("notice");
		mv.addObject("gonggao",page.getResults());
    	mv.addObject("totalPage",page.getTotalPage());
    	mv.addObject("pageNo",pageNo);
		return mv;
	}
	//用户公告详情
	@RequestMapping("/ggxq")
	public ModelAndView ggxq(Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ggxq");
    	mv.addObject("gg",userService.ggxq(id));
		return mv;
	}
	
	
	// 用户举报 Integer vid
		@RequestMapping("/jubao")
		@ResponseBody 
		public String jubao(HttpServletRequest request,Teams ls) {
			//ModelAndView mv=new ModelAndView();
			//mv.setViewName("videoplay");
			String msg="<script>alert('success');window.location='/user/videolist'</script>";
			HttpSession session = request.getSession(false);
			String oper =(String)session.getAttribute("name");
			userService.jubao(ls.getTitle(), ls.getName(), ls.getDetail(), "user",oper);
			return msg;
		}
		
		// 用户申请
		@RequestMapping("/usersq")
		public ModelAndView usersq(HttpServletRequest request,Integer pageNo,Integer status) {
			ModelAndView mv=new ModelAndView();
			if(pageNo==null) {pageNo=0;}
			if(status==null) {status=0;}
			PageUtils<Teams> page=new PageUtils<>(pageNo,5);
			HttpSession session = request.getSession(false);
			 String oper=(String)session.getAttribute("name");
			List<Teams>list=userService.info("user",oper,status);
			page.doPage(list);
			mv.setViewName("jubaostatus");
			mv.addObject("gonggao",page.getResults());
	    	mv.addObject("totalPage",page.getTotalPage());
	    	mv.addObject("pageNo",pageNo);
	    	mv.addObject("status",status);
			return mv;
		}
		
		//视频展示
		@RequestMapping("/recordvideo1")
		public ModelAndView recordvideo1(HttpServletRequest request,Integer pageNo,Integer oper) {
			ModelAndView mv=new ModelAndView("list");
			HttpSession session = request.getSession(false);
			String uname=(String)session.getAttribute("name");
			if(pageNo==null) {pageNo=0;}
			PageUtils<Operate> page=new PageUtils<>(pageNo,5);
			List<Operate>list=userService.recordOper1(uname, oper);
			page.doPage(list);
			mv.setViewName("list");
			mv.addObject("list", page.getResults());
			mv.addObject("totalPage",page.getTotalPage());
			mv.addObject("pageNo", pageNo);
			mv.addObject("oper", oper);
			return mv;
		}
}
