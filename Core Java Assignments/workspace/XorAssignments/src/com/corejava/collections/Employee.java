package com.corejava.collections;

import java.util.*;

public class Employee {
	private int id;
	Employee(int id){
		this.id=id;
	}
	public int hashCode(){
		return 9;
	}
	public boolean equals(Object obj){
			return true;
	}
	public static void main(String args[]){
		HashMap<Employee,String> hashMap=new HashMap<Employee,String>();
		Employee e1=new Employee(11);
		Employee e2=new Employee(12);
		Employee e3=new Employee(13);
		
		hashMap.put(e1,"abc");
		hashMap.put(e2,"def");
		hashMap.put(e3,"ghi");
		
		System.out.println(hashMap.get(e1));
		System.out.println(hashMap.get(e2));
		System.out.println(hashMap.get(e3));
	}
}
