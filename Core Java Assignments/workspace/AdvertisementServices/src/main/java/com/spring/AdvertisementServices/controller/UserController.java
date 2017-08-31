package com.spring.AdvertisementServices.controller;


import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.AdvertisementServices.collections.ActionCollection;
import com.spring.AdvertisementServices.collections.CategoriesCollection;
import com.spring.AdvertisementServices.entity.PostAd;
import com.spring.AdvertisementServices.entity.User;
import com.spring.AdvertisementServices.services.UserService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import java.util.*;
@RestController
@RequestMapping("/xornet")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User createUser(@RequestBody User user){
		System.out.println(user);
		return userService.createUser(user);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String login(@RequestBody User user){
		System.out.println(user);
		String authToken=userService.login(user);
		JSONObject jsonString=new JSONObject();
		jsonString.put("auth-token",authToken);
		return jsonString.toString();
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.DELETE)
	public String logout(@RequestHeader(value="auth-token") String authToken){
		System.out.println(authToken);
		return userService.logout(authToken);
	}
	
	@RequestMapping(value="/categories",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CategoriesCollection> getCategories(){
		List<CategoriesCollection> categories=userService.getCategories();
		return categories;
	}
	
	@RequestMapping(value="/actions",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ActionCollection> getActions(@RequestHeader(value="auth-token") String authToken){
		System.out.println(authToken);
		List<ActionCollection> actions=userService.getActions(authToken);
		return actions;
	}
	
	@RequestMapping(value="/postAd",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PostAd postAd(@RequestHeader(value="auth-token") String authToken,@RequestBody PostAd postad){
		System.out.println(authToken);
		return userService.postAd(authToken,postad);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getAllUsers(){
		List<User> users=new ArrayList<User>();
		users.add(new User("tom","parker","tom_pune","tom123","tom@a.c",1213231));
		users.add(new User("ivan","bond","ivan_pune","ivan123","ivan@a.c",46672));
		System.out.println(users);
		return users;
	}
	
	
	/*//QueryParam
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public  String sayHello(@RequestParam(name="name", defaultValue="Ivan") String uname){
		return "Hello "+uname;
	}
	//PathParam & HeaderParam
	@RequestMapping(value="/hello/{city}",method=RequestMethod.GET)
	public  void printPath(@PathVariable(value="city") String myCity,@RequestHeader(value="auth-token") String authToken){
		System.out.println("City : "+myCity);
		System.out.println("Auth Token : "+authToken);

	}
	//MatrixParam
	@RequestMapping(value="/matrix/{user-details}",method=RequestMethod.GET)
	public void printmatrix(@MatrixVariable(pathVar="user-details")Map<String,String> userdetails){
		System.out.println("Map : "+userdetails);
	}*/
	
}
