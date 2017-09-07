package com.springhibernate.AdvertisementServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springhibernate.AdvertisementServices.dao.UserDAO;
import com.springhibernate.AdvertisementServices.entity.Action;
import com.springhibernate.AdvertisementServices.entity.Categories;
import com.springhibernate.AdvertisementServices.entity.PostAd;
import com.springhibernate.AdvertisementServices.entity.User;
import com.springhibernate.AdvertisementServices.entity.UserSession;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDao;
	public User createUser(User user) {
		return userDao.createUser(user);
	}
	public UserSession login(User user) {
		return userDao.login(user);
	}
	public String logout(String authToken){
		return userDao.logout(authToken);
	}
	public List<Categories> getCategories() {
		return userDao.getCategories();
	}
	public List<Action> getActions(String authToken) {
		return userDao.getActions(authToken);
	}
	public PostAd postAd(String authToken,PostAd postad) {
		// TODO Auto-generated method stub
		return userDao.postAd(authToken,postad);
		}
	
	public List<User> getUserInfo(String authToken){
		return userDao.getUserInfo(authToken);
	}
	
	public List<PostAd> getAdPostedByLoggedInUser(String authToken){
		return userDao.getAdPostedByLoggedInUser(authToken);
	}
	
	public List<PostAd> getAllAds(){
		return userDao.getAllAds();
	}
	
	public String deleteAd(String authToken,int id){
		return userDao.deleteAd(authToken,id);
	}
	public PostAd updateAd(String authToken,PostAd postad) {
		// TODO Auto-generated method stub
		return userDao.updateAd(authToken,postad);
		}
	/*public Categories setCategories(Categories categories) {
		// TODO Auto-generated method stub
		return userDao.setCategories(categories);
	}*/
}