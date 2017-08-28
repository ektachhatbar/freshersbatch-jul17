package com.corejava.filehandling;

import java.io.*;

public class DataInputStreamTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file = new File("file.txt"); 
		FileInputStream fis = new FileInputStream(file); 
		DataInputStream dis = new DataInputStream(fis); 
		int id = dis.readInt(); 
		String name = dis.readUTF(); 
		double salary = dis.readDouble(); 
		System.out.println("id "+id+" name "+name+" salary "+salary);
		id = dis.readInt();
		name = dis.readUTF();
		salary = dis.readDouble();
		System.out.println("id "+id+" name "+name+" salary "+salary);
		id = dis.readInt(); 
		name = dis.readUTF(); 
		salary = dis.readDouble(); 
		System.out.println("id "+id+" name "+name+" salary "+salary);
		dis.close(); 
		fis.close();

	}

}
