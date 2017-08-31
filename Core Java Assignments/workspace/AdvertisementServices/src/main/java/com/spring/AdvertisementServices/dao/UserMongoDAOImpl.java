package com.spring.AdvertisementServices.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.AdvertisementServices.collections.ActionCollection;
import com.spring.AdvertisementServices.collections.CategoriesCollection;
import com.spring.AdvertisementServices.collections.LoginCollection;
import com.spring.AdvertisementServices.collections.PostAdCollection;
import com.spring.AdvertisementServices.collections.UserCollection;
import com.spring.AdvertisementServices.entity.PostAd;
import com.spring.AdvertisementServices.entity.User;
import com.spring.AdvertisementServices.repository.ActionRepository;
import com.spring.AdvertisementServices.repository.CategoryRepository;
import com.spring.AdvertisementServices.repository.LoginRepository;
import com.spring.AdvertisementServices.repository.PostAdRepository;
import com.spring.AdvertisementServices.repository.UserRepository;

public class UserMongoDAOImpl implements UserDAO{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	PostAdRepository postAdRepository;
	public User createUser(User user) {
		UserCollection userCollection=new UserCollection();
		userCollection.setFirstName(user.getFirstName());
		userCollection.setLastName(user.getLastName());
		userCollection.setUserName(user.getUserName());
		userCollection.setPassword(user.getPassword());
		userCollection.setEmail(user.getEmail());
		userCollection.setPhone(user.getPhone());
		userRepository.save(userCollection);
		return user;
	}
	public String login(User user) {
		LoginCollection session=null;
		List<UserCollection> users=userRepository.getUsers(user.getUserName(), user.getPassword());
		if(users.isEmpty()){
			System.out.println("Wrong Credentials");
		}else{
			System.out.println("List "+users);
			session=new LoginCollection();
			session.createSession(user);
			loginRepository.save(session);
			return session.getId();
		}
		return null;

	}
	public String logout(String authToken){
		List<LoginCollection> log=loginRepository.getToken(authToken);
		if(log.isEmpty()){
			return "Not  Logged in";
		}else{
			loginRepository.delete(authToken);
			return "Logged out Successfully";
		}
	}
	public List<CategoriesCollection> getCategories() {
		List<CategoriesCollection> categories=categoryRepository.findAll();
		return categories;
	}
	public List<ActionCollection> getActions(String authToken) {
		List<LoginCollection> log=loginRepository.getToken(authToken);
		if(log.isEmpty()){
			System.out.println("not logged in");
			return null;
		}else{
			List<ActionCollection> actions=actionRepository.findAll();
			return actions;
		}
	}
	public PostAd postAd(String authToken,PostAd postad) {
		List<LoginCollection> log=loginRepository.getToken(authToken);
		if(log.isEmpty()){
			System.out.println("not logged in");
			return null;
		}else{
			PostAdCollection postAdCollection=new PostAdCollection();
			postAdCollection.setTitle(postad.getTitle());
			postAdCollection.setName(postad.getName());
			postAdCollection.setCategory(postad.getCategory());
			postAdCollection.setDescription(postad.getDescription());
			postAdRepository.save(postAdCollection);
			return postad;
		}
	}
	

}
