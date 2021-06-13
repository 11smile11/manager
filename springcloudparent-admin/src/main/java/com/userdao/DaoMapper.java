package com.userdao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.entity.*;

@Mapper
public interface DaoMapper {
	public List<Admin> findAlladmin();//查询管理员
	public Admin findAdminByname(String aname);//查询管理员
	public List<Admin> Adminsearch(String aname);//查询管理员
	public void insrtAdminByname(@Param("aname")String aname,@Param("apasswd")String apasswd);
	public Integer deladmin(String aname);//查询管理员
	public Integer updateAdminPasswd(@Param("aname")String aname,@Param("apasswd")String apasswd);//修改管理员密码
	
	
	public List<User> findAllusr();//查询用户
	public List<User> findusrByname( @Param("uname")String uname,@Param("status")String status);//搜索用户
	public Integer updateuser(@Param("status")Integer status,@Param("uname")String uname);//修改用户状态
	public List<Video> userAndviewlist(@Param("vuname")String uname);//关联查询用户的视频信息
	
	public List<Video> findAllVideo();//浏览视频信息
	public List<Video> findVideoByid(@Param("vid")Integer vid,@Param("status")Integer status);//按照编号查找
	public Integer deVideoByid(Integer vid);//按照编号删除
	
	public Integer gonggao4(@Param("detail")String detail,@Param("title")String title,@Param("name")String name,@Param("oper")String oper);
	public List<Teams> gonggao2(@Param("manage")String manage,@Param("title")String title,@Param("status")Integer status);
	public Integer gonggao3(Integer id);
	public Teams gonggao1(Integer id);
	public Integer gonggao5(@Param("id")Integer id,@Param("status")Integer status);
		
	
}
