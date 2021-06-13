package com.contrller;


import java.io.File;
//import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.UserService;
import com.util.PageUtils;
@Controller
@RequestMapping("/admin")
public class VideoController {
	@Autowired 
	private UserService userService;
	@RequestMapping("/videolist")
	public ModelAndView  videolist(HttpServletRequest request ,Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		//初始化
		//	String msg;
		Integer newpage=0;
		if(pageNo!=null) {	newpage=pageNo; }
		
        List<Video> videolt = userService.findAllVideo();
        PageUtils<Video> page=new PageUtils<>(newpage,5);
        page.doPage(videolt);
        mav.setViewName("vlist");
		mav.addObject("videolt",page.getResults());
    	mav.addObject("totalPage",page.getTotalPage());
    	mav.addObject("pageNo",newpage);
       
		return mav;
}
	@RequestMapping("/videobyid")
	public ModelAndView  videobyid(HttpServletRequest request,Integer vid,Integer status,Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		Integer newpage=0;
		if(pageNo!=null) {	newpage=pageNo; }
		PageUtils<Video> page=new PageUtils<>(newpage,5);
		
		 if(vid==null&status==null) {
			List<Video> videolt = userService.findAllVideo();
			page.doPage(videolt);
			}
		else {
			List<Video> video = userService.findVideoByid(vid,status);
        	page.doPage(video);
		}
		mav.setViewName("vlist");
		mav.addObject("videolt",page.getResults());
		mav.addObject("totalPage",page.getTotalPage());
    	mav.addObject("pageNo",newpage);
    	mav.addObject("status",status);
		return mav;
}
	@RequestMapping("/delvideo")
	public ModelAndView delvideo(HttpServletRequest request,Integer vid,String path) {
		ModelAndView mav = new ModelAndView();
		Integer userifo = userService.deVideoByid(vid); //删除视频
		//获取视频的路径
		String videopath="D:/new wok/springcloudparent/springcloudparent-user/src/main/webapp"+path;
		 File file = new File(videopath);
		//传入路径并且删除
		 
		 if(file.exists()) {
			 file.delete();
		 }
		 
		mav.setViewName("redirect:/video/videobyid"); 
		return mav;
}
}
