package com.corejava.filehandling;

import java.io.*;

public class SerializationTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		File file = new File("serialization.txt"); 
		FileOutputStream fout = new FileOutputStream(file);  
		ObjectOutputStream out = new ObjectOutputStream(fout); 
		out.writeObject(new Account(1,new Date(11,9,1995))); 
		System.out.println("Serialized");
		out.flush(); 
		out.close();
		
	}

}
