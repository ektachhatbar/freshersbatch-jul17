package com.spring.Assignment1;

import java.util.*;

public class ChatroomBean {
	String chatRoomName;
	Set<UserBean> userbean;
	List<String> messages;
	public ChatroomBean() {
		// TODO Auto-generated constructor stub
	}
	public ChatroomBean(String chatRoomName, Set<UserBean> userbean, List<String> messages) {
		super();
		this.chatRoomName = chatRoomName;
		this.userbean = userbean;
		this.messages = messages;
	}
	public String getChatRoomName() {
		return chatRoomName;
	}
	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}
	public Set<UserBean> getUserbean() {
		return userbean;
	}
	public void setUserbean(Set<UserBean> userbean) {
		this.userbean = userbean;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
