package com.contrller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.UserService;
@Controller
@RequestMapping("/user")
public class LogonController {
	@Autowired 
	private UserService userService;
	//登录无视
	@RequestMapping("/adlogon")
	public ModelAndView  adlogon(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logon");
		return mav;
}
	@RequestMapping("/logon")
	@ResponseBody
	public ModelAndView  videolist(HttpServletRequest request,String name,String passwd) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		User log=userService.findUserByname(name);
		String msg;
		if(log!=null) {
		if(log.getPasswd().equals(passwd) ) {
			session.setAttribute("name", name);
			session.setAttribute("passwd", passwd);
			session.setAttribute("status", log.getStatus());
			mav.setViewName("index1");
		}else {
			mav.setViewName("logon");
			msg="<script>alert('用户的密码输入错误');</script>";
			mav.addObject("msg",msg);
		}}else {
			mav.setViewName("logon");
			msg="<script>alert('用户名不存在');</script>";
			mav.addObject("msg",msg);
		}
		return mav;
}
	//登出
	@RequestMapping("/logout")
	public ModelAndView  logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		session.removeAttribute("name");
		session.removeAttribute("passwd");
		mav.setViewName("logon");
		return mav;
}
	
//	@RequestMapping("/top")
//	public ModelAndView  top(HttpServletRequest request){
//		ModelAndView mav = new ModelAndView();	
//		mav.setViewName("Top");
//		return mav;
//}
	@RequestMapping("/Userregister")
	@ResponseBody
	public String  Userregister(HttpServletRequest request,User user){
		String msg;
		String name=user.getUname();
		String passwd=user.getPasswd();
		if(userService.findUserByname(name)!=null || name=="") {
			
			msg="<script>alert('注册的用户名已存在或用户名为空，请从新输入');;window.location='/user/register'"+"</script>";
			
		}else if(passwd==null || passwd=="" ){
			msg="<script>alert('密码不能为空');window.location='/user/register'"+"</script>";
		}else{
			userService.UserInsert(name, passwd);
			msg="<script>alert('注册成功');window.location='/user/adlogon'"+"</script>";
			
		}
		return msg;
}
	@RequestMapping("/register")
	public ModelAndView  register(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
}
	@RequestMapping("/contain")
	public ModelAndView  contain(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Contain");
		return mav;
}
}
