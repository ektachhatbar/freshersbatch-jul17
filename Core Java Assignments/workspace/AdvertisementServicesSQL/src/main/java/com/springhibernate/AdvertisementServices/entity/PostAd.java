package com.springhibernate.AdvertisementServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post_ad")
public class PostAd {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="postid")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="description")
	private String description;
	@Column(name="username")
	private String username;
	
	public PostAd(int id, String title, String name, String category, String description, String username) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.username = username;
	}
	public PostAd(int id, String title, String name, String category, String description) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	public PostAd() {
		// TODO Auto-generated constructor stub
	}
	public PostAd(String title, String name, String category, String description) {
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "PostAd [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category + ", description="
				+ description + ", username=" + username + "]";
	}
	
	
	
}
