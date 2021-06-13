package com.entity;

import java.io.Serializable;

public class Admin implements Serializable {

private static final long serialVersionUID = 1L;
private String aname;
private String apasswd;
private String adate;

public Admin() {
	super();
}

//public Admin(String aname,String apasswd, String adate) {
//	super();
//	this.aname = aname;
//	this.apasswd = apasswd;
//	this.adate = adate;
//}

public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public String getApasswd() {
	return apasswd;
}
public void setApasswd(String apasswd) {
	this.apasswd = apasswd;
}
public String getAdate() {
	return adate;
}
public void setAdate(String adate) {
	this.adate = adate;
}
}
