package com.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Operate;
import com.entity.Teams;
import com.entity.User;
import com.entity.Video;
public interface UserService {
	public User userOfviewlist(String uname,String status);//自己下架或者查看视频
	public Integer updateUserPasswd(String uname,String passwd);//更新密码
	public User findUserByname(String uname);//登录功能
	public List<Video>listVideo();//视频的浏览
	public List<Video> searchVideo( String vname);//视频的搜索功能
	public void uploadVideo(String vuname,String vname,String url,String image);
	public String ifvnamenull(String vname);//判断标题是有从夫
	public Integer userdel(Integer vid,Integer status);
	public Video videourl(Integer vid);
	//上传视频
	public Operate beanlike(Integer vid,String uname,Integer oper);
	public Integer recordOper(Integer vid,String uname,Integer ulike,Integer oper);
	public Integer cancelOper(Integer vid,String uname,Integer oper);
	public Integer numberOper(Integer vid,Integer oper);
	//举报功能
	
	public List<Teams> info(String manage,String oper,Integer status);
	public void jubao(String title,String name,String detail,String manage,String oper);
	public Teams ggxq(Integer id);
	
	public Integer uploadnumber(String vuname);
	public List<Video> uservideonumer();
	public Integer uservnumber(Integer vid);
	public void updatevnumber(Integer vid,Integer vnumber);
	public Integer userOpernb(String uname,Integer oper);
	public List<Operate> recordOper1(String uname,Integer oper);
	
	public void UserInsert(String uname,String passwd);//用户注册
}
