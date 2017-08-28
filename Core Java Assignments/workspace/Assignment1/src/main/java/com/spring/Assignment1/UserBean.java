package com.spring.Assignment1;

public class UserBean {
	String userName;
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	public UserBean(String userName) {
		super();
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return userName;
	}
	
	
	
}
