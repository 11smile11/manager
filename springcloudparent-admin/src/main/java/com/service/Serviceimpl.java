package com.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Admin;
import com.entity.Teams;
import com.entity.User;
import com.entity.Video;
import com.userdao.DaoMapper;

@Service
public class Serviceimpl implements UserService{
	@Autowired
	private DaoMapper dao;
	@Override
	public List<Admin> findAlladmin(){
		return dao.findAlladmin();
	}
	
	@Override
	public Admin findAdminByname(String aname) {
		return dao.findAdminByname(aname);
	}
	@Override
	public List<Admin> Adminsearch(String aname){
		return dao.Adminsearch(aname);
	}
	
	@Override
	public void insrtAdminByname(String aname,String apasswd) {
		dao.insrtAdminByname(aname,apasswd);
	}
	@Override
	public Integer deladmin(String aname) {
		return dao.deladmin(aname);
	}
	@Override
	public Integer updateAdminPasswd(String aname,String apasswd) {
		return dao.updateAdminPasswd(aname, apasswd);
	}
	
	@Override
	public List<User> findAllusr(){
		return dao.findAllusr();
	}
	
	@Override
	public List<User> findusrByname( String uname,String status){
		return dao.findusrByname(uname,status);
	}
	@Override
	public Integer updateuser(Integer status,String uname) {
		return dao.updateuser(status, uname);
	}
	
	@Override
	public List<Video> userAndviewlist(String uname){
		return dao.userAndviewlist(uname);
	}
	
	@Override
	public List<Video> findAllVideo(){
		return dao.findAllVideo();
	}
	
	@Override
	public List<Video> findVideoByid(Integer vid,Integer status) {
		return dao.findVideoByid(vid,status);
	}
	@Override
	public Integer deVideoByid(Integer vid) {
	    return dao.deVideoByid(vid);
	}
	@Override
	public Integer gonggao4(String detail,String title,String name,String oper){
		return dao.gonggao4(detail, title, name,oper);		
	}
	@Override
	public List<Teams> gonggao2(String manage,String name,Integer status){
		return dao.gonggao2(manage, name,status);
	}
	@Override
	public Integer gonggao3(Integer id){
		return dao.gonggao3(id);
	}
	@Override
	public Teams gonggao1(Integer id) {
		return dao.gonggao1(id);
				
	}
	@Override
	public Integer gonggao5(Integer id,Integer status) {
		return dao.gonggao5(id, status);
	}
}