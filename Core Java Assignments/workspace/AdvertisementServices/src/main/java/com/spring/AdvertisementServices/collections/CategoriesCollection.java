package com.spring.AdvertisementServices.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Items")
public class CategoriesCollection {
	private String id;
	private String name;
	public CategoriesCollection() {
		// TODO Auto-generated constructor stub
	}
	public CategoriesCollection(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoriesCollection [id=" + id + ", name=" + name + "]";
	}
	
}
