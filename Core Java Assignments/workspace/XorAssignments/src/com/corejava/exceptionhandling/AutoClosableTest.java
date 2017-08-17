package com.corejava.exceptionhandling;

public class AutoClosableTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		try(MyAutoCloseable ab = new MyAutoCloseable()) {
			System.out.println("Inside try"); 
		}
	}
}