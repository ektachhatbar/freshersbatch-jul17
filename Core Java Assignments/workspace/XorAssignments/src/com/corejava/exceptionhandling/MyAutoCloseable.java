package com.corejava.exceptionhandling;

public class MyAutoCloseable implements AutoCloseable { 
	@Override 
	public void close() throws Exception { 
		System.out.println("MyAutoClosable closed!"); 
	} 
}

