package com.spring.AdvertisementServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.AdvertisementServices.collections.ActionCollection;
import com.spring.AdvertisementServices.collections.CategoriesCollection;
import com.spring.AdvertisementServices.dao.UserDAO;
import com.spring.AdvertisementServices.entity.PostAd;
import com.spring.AdvertisementServices.entity.User;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDao;
	public User createUser(User user) {
		return userDao.createUser(user);
	}
	public String login(User user) {
		return userDao.login(user);
	}
	public String logout(String authToken){
		return userDao.logout(authToken);
	}
	public List<CategoriesCollection> getCategories() {
		return userDao.getCategories();
	}
	public List<ActionCollection> getActions(String authToken) {
		return userDao.getActions(authToken);
	}
	public PostAd postAd(String authToken,PostAd postad) {
		// TODO Auto-generated method stub
		return userDao.postAd(authToken,postad);
		}
}