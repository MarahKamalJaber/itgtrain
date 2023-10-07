package com.entity;

import com.dao.devdao;
import com.servlet.adddevloper;

public class devloper {
private int id;
private String name;
private String email;
private String password;
private int leaderid;



public devloper() {
	super();
	
	// TODO Auto-generated constructor stub
}
public devloper(String name, String email, String password,int leaderid ) {
	super();
	devdao a=null;
	this.name = name;
	this.email = email;
	this.password = password;
	this.leaderid = leaderid;
}
public int getLeaderid() {
	return leaderid;
}
public void setLeaderid(int leaderid) {
	this.leaderid = leaderid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
