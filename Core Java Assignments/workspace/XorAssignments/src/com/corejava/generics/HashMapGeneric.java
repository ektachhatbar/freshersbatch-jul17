package com.corejava.generics;

import java.util.*;

public class HashMapGeneric{
	
	public static void printMapKeyValues(HashMap<? extends Number,?> hm){
		System.out.println(hm.entrySet());
	}
	
	public static void main(String[] args) {
		HashMap<Integer,String> hashMap=new HashMap<Integer,String>();
		hashMap.put(1, "abc");
		
		printMapKeyValues(hashMap);
		HashMap<Integer,Double> hashMap1=new HashMap<Integer,Double>();
		hashMap1.put(11,11.11);
		
		printMapKeyValues(hashMap1);
	}

}
