package com.corejava.collections;

import java.util.concurrent.*;
import java.util.*;

public class FailSafeExample implements Runnable{
	ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<Integer,String>();
	Thread t1;
	Thread t2;
	public FailSafeExample(){
		t1=new Thread(this);
		t1.setName("add");
		t1.start();
		
		t2=new Thread(this);
		t2.setName("itr");
		t2.start();
	}
	public void run(){
		Thread currentThread=Thread.currentThread();
		
		if(currentThread.getName().equals("add")){
			
			map.put(1,"A");
			map.put(2,"B");
			map.put(3,"C");
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else{
			Iterator<Integer> it = map.keySet().iterator();
			while (it.hasNext()) {
				int key = it.next();

				System.out.println(key + " : " + map.get(key));

				map.put(4,"D");
			}
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new FailSafeExample();
	}

}
