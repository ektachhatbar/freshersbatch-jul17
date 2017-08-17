package com.corejava.collections;

import java.util.*;

public class TestListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList=new ArrayList<Integer>();
		myList.add(13);
		myList.add(7);
		myList.add(11);
		myList.add(2);
		myList.add(5);
		ListIterator<Integer> myListItr=myList.listIterator();
		System.out.println("List Iterator");
		while(myListItr.hasNext()){  
			myListItr.next();  
		}  
		while(myListItr.hasPrevious()){
			System.out.println(myListItr.previous());
		}
	}

}
