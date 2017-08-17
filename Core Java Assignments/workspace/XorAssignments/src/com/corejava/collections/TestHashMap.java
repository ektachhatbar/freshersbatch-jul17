package com.corejava.collections;

import java.util.*;

class Date{
	private int day;
	private int month;
	private int year;
	public Date(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public String toString(){
		return this.day+"-"+this.month+"-"+this.year;	
	}
	public int hashCode(){
		return 9;
	}
	public boolean equals(Object obj){
		Date d=(Date)obj;
		if(this.day==d.day&&this.month==d.month){
			return true;
		}else{
			return false;
		}
	}
	
}

public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Date,String> hashMap=new HashMap<Date,String>();
		Date d1=new Date(11,8,1995);
		Date d2=new Date(11,12,1964);
		Date d3=new Date(11,9,1990);
		Date d4=new Date(1,11,1999);
		
		hashMap.put(d1,"abc");
		hashMap.put(d2,"def");
		hashMap.put(d3,"ghi");
		hashMap.put(d4,"jkl");
		
		System.out.println(hashMap.get(d1));
		System.out.println(hashMap.get(d2));
		System.out.println(hashMap.get(d3));
		System.out.println(hashMap.get(d4));
		System.out.println(hashMap.get(new Date(11,9,1999)));
	}

}
