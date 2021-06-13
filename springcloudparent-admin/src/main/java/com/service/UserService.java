package com.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Admin;
import com.entity.Teams;
import com.entity.User;
import com.entity.Video;
public interface UserService {
	public List<Admin> findAlladmin();//查询管理员
	public Admin findAdminByname(String aname);//查询管理员
	public List<Admin> Adminsearch(String aname);//查询管理员
	public void insrtAdminByname(String aname,String apasswd);
	public Integer deladmin(String aname);//查询管理员
	public Integer updateAdminPasswd(String aname,String apasswd);//修改管理员密码
	
	
	public List<User> findAllusr();//查询用户
	public List<User> findusrByname( String uname,String status);//搜索用户
	public Integer updateuser(Integer status,String uname);//修改用户状态
	public List<Video> userAndviewlist(String uname);//关联查询用户的视频信息
	
	public List<Video> findAllVideo();//浏览视频信息
	public List<Video> findVideoByid(Integer vid,Integer status);//按照编号查找
	public Integer deVideoByid(Integer vid);//按照编号删除
	
	public Integer gonggao4(String detail,String title,String name,String oper);
	public List<Teams> gonggao2(String manage,String name,Integer status);
	public Integer gonggao3(Integer id);
	public Teams gonggao1(Integer id);
	public Integer gonggao5(Integer id,Integer status);
	
}
