package com.corejava.lambdaexpressions;

import java.util.*;

public class OddLengthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("ab");
		list.add("abc");
		list.add("abcd");
		System.out.println("Before deletion "+list);
		list.removeIf(myList->(myList.length()%2)!=0);
		System.out.println("After deletion "+list);
	}

}
