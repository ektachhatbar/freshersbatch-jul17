package com.corejava.annotations;
import java.util.*;  
import java.util.Date;  
import java.text.SimpleDateFormat;

public class myApplication {
	private class Cache{
		HashMap<Integer,String> cacheData =new HashMap<Integer,String>(); 
	}
	Cache c=new Cache();
	public void add(int data){
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		c.cacheData.put(data,timeStamp);
	}
	public String getData(int d){
		String value=(String) c.cacheData.get(d);
		return value;
	}
	
}
