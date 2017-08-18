package com.corejava.lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class MyThread implements Runnable{
	Thread t;
	List<Integer> list=new ArrayList<Integer>();
	MyThread(List<Integer> list){
		t=new Thread(this);
		t.start();
		this.list=list;
	}
	public void run(){
		Consumer<Integer> consumer = (x) -> System.out.println(x);
		this.list.forEach(consumer);
	}
	
}

public class ThreadConsumerTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		new MyThread(list1);
	}

}
