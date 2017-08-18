package com.corejava.lambdaexpressions;

import java.util.*;


public class MapStringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> hashMap=new HashMap<Integer,String>();
		hashMap.put(1, "ONE");
		hashMap.put(2,"TWO");
		hashMap.put(3,"Three");
		StringBuilder sb=new StringBuilder();
		
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			 sb.append(entry.getKey());
			 sb.append(entry.getValue());

		}
		System.out.println(sb);
	}

}
