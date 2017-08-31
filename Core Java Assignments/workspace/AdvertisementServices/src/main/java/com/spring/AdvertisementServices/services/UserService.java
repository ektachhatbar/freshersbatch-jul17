package com.spring.AdvertisementServices.services;

import java.util.List;

import com.spring.AdvertisementServices.collections.ActionCollection;
import com.spring.AdvertisementServices.collections.CategoriesCollection;
import com.spring.AdvertisementServices.entity.PostAd;
import com.spring.AdvertisementServices.entity.User;

public interface UserService {
	public User createUser(User user);
	public String login(User user);
	public String logout(String authToken);
	public List<CategoriesCollection> getCategories();
	public List<ActionCollection> getActions(String authToken);
	public PostAd postAd(String authToken,PostAd postad);
}
