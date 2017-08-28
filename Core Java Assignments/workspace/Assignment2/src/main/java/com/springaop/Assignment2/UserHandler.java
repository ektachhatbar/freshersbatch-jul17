package com.springaop.Assignment2;

import java.util.*;

public class UserHandler {
	Set<User> set=new HashSet<User>();
	public void login(String loginname,String password){
		for(User u:set){
			if(u.getLoginname().equals(loginname)&&u.getPassword().equals(password)){
				System.out.println("Login Successfully");
			}else{
				System.out.println("Login Failed");
			}
		}
	}
	public void logout(){
		
	}
	public void register(User u){
		if(u.getLoginname().length()>=3&&u.getPassword().length()>=3){
			set.add(u);
			System.out.println("Registered Successfully");
		}else{
			System.out.println("loginname and password both must be minimum 3 characters long");
		}
	}
}
