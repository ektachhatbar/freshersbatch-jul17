package com.springhibernate.AdvertisementServices.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springhibernate.AdvertisementServices.entity.Action;
import com.springhibernate.AdvertisementServices.entity.Categories;
import com.springhibernate.AdvertisementServices.entity.PostAd;
import com.springhibernate.AdvertisementServices.entity.User;
import com.springhibernate.AdvertisementServices.entity.UserSession;
import com.springhibernate.AdvertisementServices.services.UserService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import java.util.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/advertise")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User createUser(@RequestBody User user){
		System.out.println(user);
		return userService.createUser(user);
	}
	/*
	@RequestMapping(value="/categories",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Categories setCategories(@RequestBody Categories categories){
		System.out.println(categories);
		return userService.setCategories(categories);
	}*/
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String login(@RequestBody User user){
		System.out.println(user);
		UserSession us=userService.login(user);
		String authToken=us.getAuthToken();
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("auth-token",authToken);
		jsonString.put("userName",us.getUsername());
		wrapper.put("data", jsonString);
		if(!authToken.isEmpty()){
			return wrapper.toString();
		}else{
			return "Wrong Credentials";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.DELETE)
	public String logout(@RequestHeader(value="auth-token") String authToken){
		System.out.println(authToken);
		return userService.logout(authToken);
	}
	
	@RequestMapping(value="/categories",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCategories(){
		List<Categories> categories=userService.getCategories();
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("itemList", categories);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	@RequestMapping(value="/actions",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getActions(@RequestHeader(value="auth-token") String authToken){
		System.out.println(authToken);
		List<Action> actions=userService.getActions(authToken);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("actionList", actions);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	@RequestMapping(value="/postAd",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String postAd(@RequestHeader(value="auth-token") String authToken,@RequestBody PostAd postad){
		System.out.println(authToken);
		PostAd post=userService.postAd(authToken,postad);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("postId", post.getId());
		jsonString.put("auth-token", authToken);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	@RequestMapping(value="/posts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAdPostedByLoggedInUser(@RequestHeader(value="auth-token") String authToken){
		System.out.println(authToken);
		List<PostAd> user_ad=userService.getAdPostedByLoggedInUser(authToken);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("mypostList", user_ad);
		jsonString.put("data", user_ad);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getUserInfo(@RequestHeader(value="auth-token") String authToken){
		System.out.println(authToken);
		List<User> user=userService.getUserInfo(authToken);
		return user;
	}
	@RequestMapping(value="/posts/search",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllAds(){
		List<PostAd> ads=userService.getAllAds();
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("advertiseList", ads);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	@RequestMapping(value="/post",method=RequestMethod.DELETE)
	public String deleteAd(@RequestHeader(value="auth-token") String authToken,@RequestParam(name="postId") int id){
		System.out.println(authToken+"hello "+id);
		return userService.deleteAd(authToken,id);
	}
	
	@RequestMapping(value="/postAd",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateAd(@RequestHeader(value="auth-token") String authToken,@RequestBody PostAd postad){
		System.out.println(authToken);
		PostAd post=userService.updateAd(authToken,postad);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("postId", post.getId());
		jsonString.put("auth-token", authToken);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	/*@RequestMapping(value="/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getAllUsers(){
		List<User> users=new ArrayList<User>();
		users.add(new User("tom","parker","tom_pune","tom123","tom@a.c",1213231));
		users.add(new User("ivan","bond","ivan_pune","ivan123","ivan@a.c",46672));
		System.out.println(users);
		return users;
	}*/
	
	
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
