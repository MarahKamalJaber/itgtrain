package com.entity;

public class status {
private int suid;
	
	private String statusname;
	
	
public status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public status(String statusname) {
	super();
	this.statusname = statusname;
	
}

	public int getSuid() {
		return suid;
	}

	public void setSuid(int suid) {
		this.suid = suid;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	
	
	
}
