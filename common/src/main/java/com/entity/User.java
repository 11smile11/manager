package com.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class User implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

private String uname;
private String passwd;
private String date;
private String status;
@JsonIgnoreProperties(value="user")
private List<Video> video;

public User() {
	super();
}

//public User(String uname ,String passwd ,String date,String status,List<Video> video) {
//	super();
//	this.passwd = passwd;
//	this.uname = uname;
//	this.date = date;
//	this.status =status;
//	this.video = video;
//}

public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

public List<Video> getVideo() {
	return video;
}

public void setVideo(List<Video> video) {
	this.video = video;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
}
