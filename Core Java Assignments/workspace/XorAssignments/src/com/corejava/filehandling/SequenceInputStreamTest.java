package com.corejava.filehandling;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamTest {

	public static void main(String[] args) throws Exception{
		FileInputStream fin1=new FileInputStream("file1.txt");  
		FileInputStream fin2=new FileInputStream("file2.txt");
		FileInputStream fin3=new FileInputStream("file3.txt");
		
		Vector<InputStream> vc=new Vector<InputStream>();
		vc.add(fin1);
		vc.add(fin2);
		vc.add(fin3);
		Enumeration<InputStream> enu=vc.elements();
		SequenceInputStream sis=new SequenceInputStream(enu); 
		int i;  
		while((i=sis.read())!=-1){  
			System.out.print((char)i);  
		}  
		sis.close(); 
		fin1.close(); 
		fin2.close();
		fin2.close();
	}

}
