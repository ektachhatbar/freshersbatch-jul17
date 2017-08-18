package com.corejava.generics;

import java.util.*;

public class MyWrapMethodTest {

	public static void main(String[] args) {
		MyWrapMethod wrap=new MyWrapMethod();
		List<Integer> myList=new ArrayList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		wrap.process(myList);
		List<String> myList1=new ArrayList<String>();
		myList1.add("abc");
//		wrap.process(myList1);  error

	}

}
