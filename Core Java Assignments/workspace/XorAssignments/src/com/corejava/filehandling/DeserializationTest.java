package com.corejava.filehandling;

import java.io.*;

public class DeserializationTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file = new File("serialization.txt"); 
		FileInputStream fin = new FileInputStream(file);  
		ObjectInputStream in = new ObjectInputStream(fin); 
		Account account = (Account)in.readObject(); 
		System.out.println("Account = " + account);
		System.out.println("Deserialized");
	}

}
