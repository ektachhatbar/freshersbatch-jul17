package com.corejava.collections;

import java.util.*;

public class TestHashSetLinkedHastSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> hashSet=new HashSet<Integer>();
		hashSet.add(13);
		hashSet.add(7);
		hashSet.add(11);
		hashSet.add(2);
		hashSet.add(5);
		
		Iterator<Integer> hashSetItr=hashSet.iterator();
		System.out.println("Hash Set");
		while(hashSetItr.hasNext()){
			System.out.println(hashSetItr.next());
		}
		
		Set<Integer> linkedHashSet=new LinkedHashSet<Integer>();
		linkedHashSet.add(13);
		linkedHashSet.add(7);
		linkedHashSet.add(11);
		linkedHashSet.add(2);
		linkedHashSet.add(5);
		
		Iterator<Integer> linkedHashSetItr=linkedHashSet.iterator();
		System.out.println("Linked Hash Set");
		while(linkedHashSetItr.hasNext()){
			System.out.println(linkedHashSetItr.next());
		}
	}

}
