package com.corejava.filehandling;
import java.io.*;
public class FileHandlingTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file1 = new File("file1.txt"); 
		FileInputStream fis = new FileInputStream(file1); 
		StringBuilder sb = new StringBuilder(""); 
		int i = 0; 
		do { 
			i = fis.read(); 
			if(i != -1) 
				sb.append((char)i); 
		} while(i != -1);
		File file2 = new File("file3.txt");
		FileOutputStream fos = new FileOutputStream(file2); 
		fos.write(sb.toString().getBytes()); 
		fos.flush(); 
		fos.close();
	}

}
