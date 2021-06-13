package com.userdao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.entity.*;
@Mapper
public interface UserDaoMapper {
	
	public User userOfviewlist(@Param("uname")String uname,@Param("status")String status);//关联查询用户的视频信息
	public Integer updateUserPasswd(@Param("uname")String aname,@Param("passwd")String apasswd);//修改密码
	public User findUserByname(String uname);//登录查询
	public List<Video>listVideo();//浏览视频信息
	public List<Video> searchVideo( String vname);//搜索用户
	public void uploadVideo(@Param("vuname")String vuname,@Param("vname")String vname,@Param("url")String url,@Param("image")String image);
	public String ifvnamenull(@Param("vname")String vname);
	public Integer userdel(@Param("vid")Integer vid,@Param("status")Integer status);
	public Operate beanlike(@Param("vid")Integer vid,@Param("uname") String uname,@Param("oper")Integer oper);
	public Integer recordOper(@Param("vid")Integer vid,@Param("uname") String uname,@Param("ulike")Integer ulike,@Param("oper")Integer oper);
	public Integer cancelOper(@Param("vid")Integer vid,@Param("uname") String uname,@Param("oper")Integer oper);
	public Integer numberOper(@Param("vid")Integer vid,@Param("oper")Integer oper);
	
	public List<Teams> info(@Param("manage")String manage,@Param("oper")String oper,@Param("status")Integer status);
	public void jubao(@Param("title")String title,@Param("name")String name,@Param("detail")String detail,@Param("manage")String manage,@Param("oper")String oper);
	public Teams ggxq(Integer id);
	
	public Integer uploadnumber(@Param("vuname")String vuname);
	public List<Video> uservideonumer();
	public Integer uservnumber(@Param("vid")Integer vid);
	public void updatevnumber(@Param("vid")Integer vid,@Param("vnumber")Integer vnumber);
	public Integer userOpernb(@Param("uname")String uname,@Param("oper")Integer oper);
	public Video videourl(Integer vid);
	public List<Operate> recordOper1(@Param("uname")String uname,@Param("oper")Integer oper);
	public void UserInsert(@Param("uname")String uname,@Param("passwd")String passwd);
}
