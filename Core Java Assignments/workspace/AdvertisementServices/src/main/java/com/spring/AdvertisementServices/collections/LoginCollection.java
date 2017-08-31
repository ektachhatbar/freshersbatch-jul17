package com.spring.AdvertisementServices.collections;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spring.AdvertisementServices.entity.User;

@Document(collection="user_session")
public class LoginCollection {
	@Id
	private String id;
	private String userName;
	private String date;
	public LoginCollection() {
		// TODO Auto-generated constructor stub
	}
	public LoginCollection(String id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
		this.date=new Date().toString();
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "LoginCollection [Id=" + id + ", username=" + userName + "]";
	}
	public void createSession(User user){
		this.setUserName(user.getUserName());
		this.setDate(new Date().toString());
	}
}
