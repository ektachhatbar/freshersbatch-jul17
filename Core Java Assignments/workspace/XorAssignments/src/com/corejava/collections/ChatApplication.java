package com.corejava.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

class ChatRoom {
	String name;
	Map<String, String> usersDetails = new HashMap<String, String>();
	ArrayList<String> messages = new ArrayList<String>();
	public ChatRoom(String name){
		this.name = name;
	}
	public void addUser(String username, String password){
		usersDetails.put(username, password);
	}
	public void displayUser(){
		Set<String> userNames = usersDetails.keySet();
		//System.out.println(usersDetails.size());
		Iterator<String> itr = userNames.iterator();
		for(int i=0;i<usersDetails.size();i++){
			System.out.println(itr.next());
		}
	}
	public boolean checkCredentials(String username, String password) {
		if(password.equals(this.usersDetails.get(username))){
			return true;
		}
		else{
			return false;
		}
	}
	public void removeUser(String username) {
		usersDetails.remove(username);
	}
	public void addMessage(String message) {
		this.messages.add(message);
	}
	public void displayMessages() {
		for(int i=0;i<this.messages.size();i++){
			System.out.println(messages.get(i));
		}
	}
}
public class ChatApplication {
	public static int charRoomCount =0;
	
	public static ChatRoom searchChatRoom(Vector<ChatRoom> roomlist, String roomName){
		ChatRoom foundChatRoom = null;
		//System.out.println("Size is" + roomlist.size());
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).name.equals(roomName)) {
				foundChatRoom = roomlist.get(i);
				break;
			}
		}
		return foundChatRoom;
	}
	public static void deleteChatRoom(Vector<ChatRoom> roomlist, String roomName) {
		for(int i=0;i<roomlist.size();i++) {
			if(roomlist.get(i).name.equals(roomName)) {
				roomlist.remove(i);
				break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		  Vector<ChatRoom> roomlist = new Vector<ChatRoom>();
		
		while(true){
			System.out.println("1 for Create a chatroom");
			System.out.println("2 for Add the user");
			System.out.println("3 Enter Into ChatRoom");
			System.out.println("4 for Display the messages from a specific chatroom");
			System.out.println("5 for List down all users belonging to the specified chat room");
			System.out.println("6 for Delete an user");
			System.out.println("7 for Delete the chat room.");
			System.out.println("Please enter your option:");
			switch(Integer.parseInt(scan.nextLine())){
			case 1:
				System.out.println("Enter ChatRoom name:");
				ChatRoom newRoom = new ChatRoom(scan.nextLine());
				//System.out.println(newRoom.name);
				roomlist.add(newRoom);
				System.out.println("ChatRoom Added");
			break;
			case 2:
				System.out.println("Enter user name:");
				String username2 = scan.nextLine();
				System.out.println("Enter password:");
				String password2 = scan.nextLine();
				System.out.println("Enter Chatroom name where user to be added:");
				String chatroom2 = scan.nextLine();
				ChatRoom foundRoom2 = searchChatRoom(roomlist,chatroom2);
				//System.out.println(foundRoom2.name);
				if(foundRoom2 instanceof ChatRoom)
					foundRoom2.addUser(username2, password2);
				else
					System.out.println("user  not added");
			break;
			case 3:
				System.out.println("Enter ChatRoom name:");
				String chatroom3 = scan.nextLine();
				ChatRoom foundRoom3 = searchChatRoom(roomlist,chatroom3);
				System.out.println("Enter user name:");
				String username3 = scan.nextLine();
				System.out.println("Enter password:");
				String password3 = scan.nextLine();
				if(foundRoom3 instanceof ChatRoom) {
					boolean cond = foundRoom3.checkCredentials(username3,password3);
					if(cond){
						System.out.println("User Looged in");
						login:while(true) {
							System.out.println("1 for Send a message");
							System.out.println("2 for Logout");
							switch(Integer.parseInt(scan.nextLine())){
							case 1:
								System.out.println("----------Enter Message:--------------");
								String message = scan.nextLine();
								foundRoom3.addMessage(message);
								System.out.println("------------------ Message Added-------------");
							break;
							case 2:
								break login;
							}
						}
					}
					else
						System.out.println("Wrong Credentials");
				}
			break;
			case 4:
				System.out.println("Enter ChatRoom name:");
				String chatroom4 = scan.nextLine();
				ChatRoom foundRoom4 = searchChatRoom(roomlist,chatroom4);
				if(foundRoom4 instanceof ChatRoom) {
					System.out.println("---------------------"  + chatroom4 + "Messages--------------------");
					foundRoom4.displayMessages();
					System.out.println("-------------------------------------------------------------------");
				}
				else{
					System.out.println("No ChatRoom Exist");
				}
			break;
			case 5:
				System.out.println("Enter ChatRoom name:");
				String chatroom5 = scan.nextLine();
				ChatRoom foundRoom5 = searchChatRoom(roomlist,chatroom5);
				if(foundRoom5 instanceof ChatRoom){
					System.out.println("-----------user list--------------");
					foundRoom5.displayUser();
				}
				else
					System.out.println("user list not printed");
				System.out.println("-----------------------------------");
			break;
			case 6:
				System.out.println("Enter user name:");
				String username6 = scan.nextLine();
				System.out.println("Enter password:");
				String password6 = scan.nextLine();
				System.out.println("Enter ChatRoom name:");
				String chatroom6 = scan.nextLine();
				ChatRoom foundRoom6 = searchChatRoom(roomlist,chatroom6);
				if(foundRoom6 instanceof ChatRoom) {
					foundRoom6.removeUser(username6);
				}
			break;
			case 7:
				System.out.println("Enter ChatRoom name:");
				String chatroom7 = scan.nextLine();
				System.out.println("------------------ChatRoom Deleted--------------");
			break;
			}
		}
	}

}
