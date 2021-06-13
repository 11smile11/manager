package com.contrller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.*;
import com.service.UserService;
import com.util.*;

@Controller
@RequestMapping("/user")
public class VideoController {
	@Autowired 
	private UserService userService;
	
	//视频浏览
	@RequestMapping("/videolist")
	public ModelAndView  videolist(HttpServletRequest request ,Integer pageNo,String uname) {
		ModelAndView mav = new ModelAndView();
		//初始化
		//String msg;
		Integer newpage=0;
		if(pageNo!=null) {	newpage=pageNo; }
		if(uname==null) {	uname=""; }
        List<Video> videolt = userService.listVideo();
        List<Video> copylist = new ArrayList<Video>();
        for(int i=0;i<videolt.size();i++) {
        	if( (videolt.get(i).getVname().indexOf(uname))>-1) {
       			copylist.add(videolt.get(i));
       		}
        }
        PageUtils<Video> page=new PageUtils<>(newpage,6);
        page.doPage(copylist);
        mav.setViewName("videolist");
		mav.addObject("videolt",page.getResults());
    	mav.addObject("totalPage",page.getTotalPage());
    	mav.addObject("pageNo",newpage);
    	mav.addObject("uname",uname);
//        }
		return mav;
}
	 //上传操作
		@RequestMapping("/upload")
		    public ModelAndView upload() {
			ModelAndView mav = new ModelAndView("upload");
			return mav;
		    }

		@RequestMapping("/videoUpload")
		    public ModelAndView videoUpload( MultipartFile file, HttpServletRequest request,String vname) {
			 ModelAndView mav = new ModelAndView("upload");
			 String msg;
			 HttpSession session = request.getSession(false);
			 String vuname=(String)session.getAttribute("name");
			  
		        if (file.isEmpty()) {
		        	msg="<script>alert('没有上传文件，请重新上传');</script>";
		        	mav.addObject("msg",msg);
		        }else {
		        String fileName = file.getOriginalFilename();  // 文件名
		        String filePath =request.getSession().getServletContext().getRealPath("/static/video/"+vuname+"/"); // 视频上传后的路径
		        String filePath1=filePath + fileName;
		        String imageName = fileName.substring(0, fileName.lastIndexOf(".")); // 文件名
		        String imagePath =request.getSession().getServletContext().getRealPath("/static/image/"+vuname+"/");// 上传后的图片
		        File dest = new File(filePath1);
		        //File dest1 = new File(imagePath + imageName);
		        if (!dest.getParentFile().exists()) {
		            dest.getParentFile().mkdirs();  }
		        
		        
		        //视频文件或标题不存在判断上传通过
		        if(userService.ifvnamenull(vname)==null && (!dest.exists())) {
		        	//相对地址
		        	String fileurl = "/static/video/"+vuname+"/"+ fileName;//视频地址
			        String imageurl = "/static/image/"+vuname+"/"+imageName+".jpg";//图片地址
		        	try {
		        		file.transferTo(dest);
		        		//视频取帧处理(视频路径、图片存储路径、图片名称）
		        		VideoUtils.randomGrabberFFmpegImage(filePath1, imagePath,imageName);
		        	} catch (IOException e) {
		        		e.printStackTrace();
		        	}
		        	userService.uploadVideo(vuname,vname,fileurl,imageurl);
		        	mav.addObject("filename", fileurl);
		        	msg="<script>alert('上传已完成');</script>";
		        	mav.addObject("msg",msg);
		        }else {
		        	msg="<script>alert('标题或者文件名已经存在，请从新输入');</script>";
		        	mav.addObject("msg",msg);
		        } }
		        return mav;
		    }
		 
		//上传操作
		@RequestMapping("/onlineupload")
		    public ModelAndView onlineupload() {
			ModelAndView mav = new ModelAndView("onlineupload");
			return mav;
		    }
		
		@RequestMapping("/videoOnline")
	    public ModelAndView videoOnline( HttpServletRequest request,String vname,String fileurl) {
		 ModelAndView mav = new ModelAndView("onlineupload");
		 String msg;
		 HttpSession session = request.getSession(false);
		 String vuname=(String)session.getAttribute("name");
	        if (fileurl.isEmpty()) {
	        	msg="<script>alert('没有上传文件，请重新上传');</script>";
	        	mav.addObject("msg",msg);
	        }else {
			    String imageName = vname; // 文件名
			    String imagePath =request.getSession().getServletContext().getRealPath("/static/image/"+vuname+"/");// 上传后的图片
	        	try {
	        		//视频取帧处理(视频路径、图片存储路径、图片名称）
	        		VideoUtils.randomGrabberFFmpegImage(fileurl, imagePath,imageName);
        			} catch (IOException e) {
        				e.printStackTrace();
        			} 
	        String imageurl = "/static/image/"+vuname+"/"+ imageName+".jpg";
	        if(userService.ifvnamenull(vname)==null ){
	        	userService.uploadVideo(vuname,vname,fileurl,imageurl);
	        	mav.addObject("filename", fileurl); 
	        	msg="<script>alert('Url已经上传');</script>";
	        	mav.addObject("msg",msg);
	        }else{
	        	msg="<script>alert('标题或者文件名已经存在，请从新输入');</script>";
	        	mav.addObject("msg",msg);
	        } 
	        }
	        return mav;
	    }
		//视频播放 操作数3
		@RequestMapping("/videopaly")
	    public ModelAndView videopaly(HttpServletRequest request,Integer vid) {
		ModelAndView mav = new ModelAndView("videoplay");
		//点击视频数字加一
			Integer vnumber=(userService.uservnumber(vid)+1);
			userService.updatevnumber(vid,vnumber);
			//根据视频id获取url
			String url=(String)userService.videourl(vid).getUrl();
			mav.addObject("url",url);
			mav.addObject("vid",vid);
			return mav;
	    }
		
		//点赞 oper数为1
		@RequestMapping("/like")
		@ResponseBody
	    public String like( HttpServletRequest request,Integer vid) {
			HttpSession session=request.getSession(false);
			String uname=(String)session.getAttribute("name");
			
			//判断是否点赞()输入vid，user，操作数是否为空，为空没有点赞，不为空点过赞了
			if(userService.beanlike(vid, uname, 1)==null) {
			//然后否操作表输入vid，user，操作数，like
				userService.recordOper(vid, uname, 1, 1);
			}else {
			//若以经点过攒了，删除该条记录输入vid，user，操作数
				userService.cancelOper(vid, uname, 1);
			}
			//查询vid和操作数的数目返回
			int count;
			if(userService.numberOper(vid, 1)==null) {
				count=0;
			}else {
			count=userService.numberOper(vid, 1);
			}
			//mav.addObject("url",vid);
			return String.valueOf(count);
	    }
		
		//点赞 数传递
		@RequestMapping("/likenumber")
		@ResponseBody
		public String likenumber(HttpServletRequest request,Integer vid) {
			int count=userService.numberOper(vid, 1);
			return String.valueOf(count);	
		}

		
		//收藏 数传递
				@RequestMapping("/collectnumber")
				@ResponseBody
				public String collectnumber(HttpServletRequest request,Integer vid) {
					HttpSession session=request.getSession(false);
					String uname=(String)session.getAttribute("name");
					String mav;
					//判断是否点赞()输入vid，user，操作数是否为空，为空没有点赞，不为空点过赞了
					if(userService.beanlike(vid,uname,2)==null) {
					//然后否操作表输入vid，user，操作数，like
						mav="未收藏";
					}else {
					//若以经点过攒了，删除该条记录输入vid，user，操作数
						mav="已经收藏";
					}
					return mav;
			    }
		
		//收藏 oper数2
		@RequestMapping("/collect")
		@ResponseBody
		 public String collect( HttpServletRequest request,Integer vid) {
			HttpSession session=request.getSession(false);
			String uname=(String)session.getAttribute("name");
			String mav;
			//判断是否点赞()输入vid，user，操作数是否为空，为空没有点赞，不为空点过赞了
			if(userService.beanlike(vid,uname,2)==null) {
			//然后否操作表输入vid，user，操作数，like
				userService.recordOper(vid, uname,1,2);
				mav="已经收藏";
			}else {
			//若以经点过攒了，删除该条记录输入vid，user，操作数
				userService.cancelOper(vid, uname,2);
				mav="未收藏";
			}
			return mav;
	    }
}
