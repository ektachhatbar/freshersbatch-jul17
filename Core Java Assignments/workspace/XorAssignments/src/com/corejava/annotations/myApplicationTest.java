package com.corejava.annotations;

public class myApplicationTest {

	public static void main(String[] args) {
			myApplication myApp=new myApplication();
			myApp.add(10);
			myApp.add(20);
			myApp.add(30);
			System.out.println(myApp.getData(20));
	}

}
