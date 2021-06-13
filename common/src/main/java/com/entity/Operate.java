package com.entity;

import java.io.Serializable;

public class Operate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Integer vid;
	private String uname;
	private Integer ulike;
	private Integer oper;
	private Video video;
	
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUlike() {
		return ulike;
	}
	public void setUlike(Integer ulike) {
		this.ulike = ulike;
	}
	public Integer getOper() {
		return oper;
	}
	public void setOper(Integer oper) {
		this.oper = oper;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
}
