package com.spring.AdvertisementServices.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Actions")
public class ActionCollection {
	private String id;
	private String name;
	public ActionCollection() {
		// TODO Auto-generated constructor stub
	}
	public ActionCollection(String id, String name) {
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
		return "ActionCollection [id=" + id + ", name=" + name + "]";
	}
	
}
