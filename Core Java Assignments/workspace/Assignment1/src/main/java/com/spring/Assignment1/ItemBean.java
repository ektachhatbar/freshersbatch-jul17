package com.spring.Assignment1;

public class ItemBean {
	private String itemName;
	private double itemprice;
	public ItemBean() {
		// TODO Auto-generated constructor stub
	}
	public ItemBean(String itemName, double itemprice) {
		super();
		this.itemName = itemName;
		this.itemprice = itemprice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemprice() {
		return itemprice;
	}
	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}
	
}
