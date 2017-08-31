package com.spring.AdvertisementServices.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="postAd")
public class PostAdCollection {
	@Id
	private String id;
	private String title;
	private String name;
	private String category;
	private String description;
	
	public PostAdCollection() {
		// TODO Auto-generated constructor stub
	}

	public PostAdCollection(String id, String title, String name, String category, String description) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "PostAdCollection [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category
				+ ", description=" + description + "]";
	}
	
}
