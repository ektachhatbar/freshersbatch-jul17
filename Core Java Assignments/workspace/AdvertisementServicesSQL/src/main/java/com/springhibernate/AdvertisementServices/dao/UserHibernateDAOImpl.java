package com.springhibernate.AdvertisementServices.dao;

import java.util.*;

import org.hibernate.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.AdvertisementServices.entity.Action;
import com.springhibernate.AdvertisementServices.entity.Categories;
import com.springhibernate.AdvertisementServices.entity.PostAd;
import com.springhibernate.AdvertisementServices.entity.User;
import com.springhibernate.AdvertisementServices.entity.UserSession;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class UserHibernateDAOImpl extends HibernateDaoSupport implements UserDAO{
	@Transactional
	public User createUser(User user) {
		getHibernateTemplate().save(user);
		return user;
	}
	
	@Transactional
	public UserSession login(User user) {
		List<User> userLogin=(List<User>) getHibernateTemplate().find("from User where userName=? AND password=?", user.getUserName(),user.getPassword());
		for(User u:userLogin){
			UserSession userSession=new UserSession();
			userSession.setUsername(u.getUserName());
			userSession.setAuthToken(generateAuthToken());
			userSession.setLast_updated_date(new Date());
			getHibernateTemplate().save(userSession);
			return userSession;
		}
		return null;
	}
	
	@Transactional
	public String logout(String authToken){
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		if(userSession.isEmpty()){
			return "Not Logged In";
		}else{
			getHibernateTemplate().deleteAll(userSession);
			return "Logout Successfully";
		}
	}
	public List<Categories> getCategories() {
		List<Categories> categories=(List<Categories>) getHibernateTemplate().find("from Categories");
		System.out.println(categories);
		return categories;

	}
	public List<Action> getActions(String authToken) {
		List<Action> actionList;
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		
		if(userSession.isEmpty()){
			System.out.println("Not Logged In");
		}else{
			actionList=(List<Action>) getHibernateTemplate().find("from Action");
			return actionList;
		}
		return null;
	}
	@Transactional
	public PostAd postAd(String authToken,PostAd postad) {
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		if(userSession.isEmpty()){
			System.out.println("Not logged in");
			return null;
		}else{
			postad.setUsername(userSession.get(0).getUsername());
			getHibernateTemplate().save(postad);
			return postad;
		}

	}
	/*@Transactional
	public Categories setCategories(Categories categories) {
		getHibernateTemplate().save(categories);
		return categories;
	}*/
	public static String generateAuthToken(){
		UUID no=UUID.randomUUID();
		return no.toString();
	}

	public List<User> getUserInfo(String authToken) {
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		
		if(userSession.isEmpty()){
			System.out.println("Not logged in");
			return null;
		}else{
			System.out.println("name "+userSession.get(0).getUsername());
			String uname=userSession.get(0).getUsername();
			System.out.println("name 2"+uname);
			List<User> userInfo=(List<User>) getHibernateTemplate().find("from User where userName=?",uname);
			System.out.println("user Info"+userInfo);

			if(userInfo.isEmpty()){
				System.out.println("No Such User");
				return null;
			}else{
				return userInfo;
			}
		}
	
	}
	public List<PostAd> getAdPostedByLoggedInUser(String authToken){
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		if(userSession.isEmpty()){
			System.out.println("Not logged in");
			return null;
		}else{
			String uname=userSession.get(0).getUsername();
			System.out.println("uname "+uname);
			List<PostAd> adList=(List<PostAd>) getHibernateTemplate().find("from PostAd where username=?", uname);
			if(adList.isEmpty()){
				System.out.println("No Such User");
				return null;
			}else{
				return adList;
			}
		}
	}
	public List<PostAd> getAllAds(){
		List<PostAd> ads=(List<PostAd>) getHibernateTemplate().find("from PostAd");
		System.out.println(ads);
		return ads;
	}
	@Transactional
	public String deleteAd(String authToken,int id){
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		if(userSession.isEmpty()){
			return "Not Logged In";
		}else{
			List<PostAd> ads=(List<PostAd>) getHibernateTemplate().find("from PostAd where id=?",id);
			getHibernateTemplate().deleteAll(ads);
			JSONObject json = new JSONObject();
			json.put("message", "deleted successfully");
			return json.toString();
		}	
		}
	@Transactional
	public PostAd updateAd(String authToken,PostAd postad){
		List<UserSession> userSession=(List<UserSession>) getHibernateTemplate().find("from UserSession where authToken=?", authToken);
		if(userSession.isEmpty()){
			System.out.println("Not logged in");
			return null;
		}else{
			/*postad.setUsername(userSession.get(0).getUsername());
			getHibernateTemplate().saveOrUpdate(postad);
			return postad;*/
            Query updateAd = getHibernateTemplate()
            .getSessionFactory()
            .getCurrentSession()
            .createQuery("Update PostAd set title=:newTitle,name=:newName,category=:newCategory,description=:newDescription,username=:newUsername where id=:pid");
            updateAd.setParameter("newTitle", postad.getTitle());
            updateAd.setParameter("newName", postad.getName());
            updateAd.setParameter("newCategory", postad.getCategory());
            updateAd.setParameter("newDescription", postad.getDescription());
            updateAd.setParameter("newUsername", userSession.get(0).getUsername());
            updateAd.setParameter("pid", postad.getId());
            int ifUpdate = updateAd.executeUpdate();
            return postad;

		}
	}
}
