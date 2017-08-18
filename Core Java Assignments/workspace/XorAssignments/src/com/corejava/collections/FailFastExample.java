package com.corejava.collections;

import java.util.*;

public class FailFastExample implements Runnable{
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	Thread t1;
	Thread t2;
	public FailFastExample(){
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
			
			for(int i=0;i<5;i++){
				list.add(i);
				
			}
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else{
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				list.add(8);
			}
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new FailFastExample();
	}

}
