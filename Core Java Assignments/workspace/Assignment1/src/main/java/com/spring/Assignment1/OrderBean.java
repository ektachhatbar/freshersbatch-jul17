package com.spring.Assignment1;

public class OrderBean {
	private int orderID;
	private ItemBean itembean;
	public OrderBean() {
		// TODO Auto-generated constructor stub
	}
	public OrderBean(int orderID, ItemBean itembean) {
		super();
		this.orderID = orderID;
		this.itembean = itembean;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public ItemBean getItembean() {
		return itembean;
	}
	public void setItembean(ItemBean itembean) {
		this.itembean = itembean;
	}
	
}
