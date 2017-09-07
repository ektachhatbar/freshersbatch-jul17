package com.springhibernate.AdvertisementServices.dao;

import java.util.List;

import com.springhibernate.AdvertisementServices.entity.Action;
import com.springhibernate.AdvertisementServices.entity.Categories;
import com.springhibernate.AdvertisementServices.entity.PostAd;
import com.springhibernate.AdvertisementServices.entity.User;
import com.springhibernate.AdvertisementServices.entity.UserSession;

public interface UserDAO {
	public User createUser(User user);
	public UserSession login(User user);
	public String logout(String authToken);
	//public Categories setCategories(Categories categories);
	public List<Categories> getCategories();
	public List<Action> getActions(String authToken);
	public PostAd postAd(String authToken,PostAd postad);
	public List<User> getUserInfo(String authToken);
	public List<PostAd> getAdPostedByLoggedInUser(String authToken);
	public List<PostAd> getAllAds();
	public String deleteAd(String authToken,int id);
	public PostAd updateAd(String authToken,PostAd postad);
}
