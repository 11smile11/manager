package com.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Video implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
private Integer vid;
private String vuname;
private String vname;
private String vdata;
private String url;
private String status;
private Integer vnumber;
private String image;

@JsonIgnoreProperties(value="video")
private User user;

public Video() {
	super();
}

public Integer getVid() {
	return vid;
}
public void setVid(Integer vid) {
	this.vid = vid;
}
public String getV_uname() {
	return vuname;
}
public void setV_uname(String v_uname) {
	this.vuname = v_uname;
}
public String getVname() {
	return vname;
}
public void setVname(String vname) {
	this.vname = vname;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getVdata() {
	return vdata;
}
public void setVdata(String vdata) {
	this.vdata = vdata;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public Integer getVnumber() {
	return vnumber;
}

public void setVnumber(Integer vnumber) {
	this.vnumber = vnumber;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

}
