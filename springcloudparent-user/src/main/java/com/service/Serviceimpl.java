package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Operate;
import com.entity.Teams;
import com.entity.User;
import com.entity.Video;
import com.userdao.UserDaoMapper;

@Service
public class Serviceimpl implements UserService{
	@Autowired
	private UserDaoMapper dao;
	@Override
	public User userOfviewlist(String uname,String status){
		return dao.userOfviewlist(uname,status);
	}
	@Override
	public void UserInsert(String uname,String passwd) {
		dao.UserInsert(uname, passwd);
	}
	@Override
	public Integer updateUserPasswd(String uname,String passwd) {
		return dao.updateUserPasswd(uname, passwd);
	}
	@Override
	public List<Video>listVideo(){
		return dao.listVideo();
	}
	@Override
	public List<Video> searchVideo( String vname){
		return dao.searchVideo(vname);
	}
	@Override
	public User findUserByname(String uname) {
		return dao.findUserByname(uname);
	}
	@Override
	public void uploadVideo(String vuname,String vname,String url,String image) {
		 dao.uploadVideo(vuname, vname, url,image);
	}
	@Override
	public String ifvnamenull(String vname) {
		return dao.ifvnamenull(vname);
	}
	@Override
	public Integer userdel(Integer vid,Integer status) {
		return dao.userdel(vid, status);
	}
	@Override
	public Operate beanlike(Integer vid,String uname,Integer oper) {
		return dao.beanlike(vid, uname, oper);
	}
	@Override
	public Integer recordOper(Integer vid,String uname,Integer ulike,Integer oper) {
		return dao.recordOper(vid, uname, ulike, oper);
	}
	@Override
	public Integer cancelOper(Integer vid,String uname,Integer oper) {
		return dao.cancelOper(vid, uname, oper);
	}
	@Override
	public Integer numberOper(Integer vid,Integer oper) {
		return dao.numberOper(vid, oper);
	}
	@Override
	public Integer uploadnumber(String vuname) {
		return dao.uploadnumber(vuname);
	}
	@Override
	public List<Video> uservideonumer() {
		return dao.uservideonumer();
	}
	@Override
	public Integer uservnumber(Integer vid) {
		return dao.uservnumber(vid);
	}
	@Override
	public void updatevnumber(Integer vid,Integer vnumber) {
		dao.updatevnumber(vid, vnumber);
	}
	@Override
	public Integer userOpernb(String uname,Integer oper) {
		return dao.userOpernb(uname, oper);
	}
	@Override
	public List<Teams> info(String manage,String oper,Integer status){
		return dao.info(manage,oper,status);
	}
	@Override
	public void jubao(String title,String name,String detail,String manage,String oper) {
		dao.jubao(title, name, detail, manage,oper);
	}
	@Override
	public Teams ggxq(Integer id){
		return dao.ggxq(id);
	}
	@Override
	public Video videourl(Integer vid) {
		return dao.videourl(vid);
	}
	public List<Operate> recordOper1(String uname,Integer oper) {
		return dao.recordOper1(uname, oper);
	}
}
