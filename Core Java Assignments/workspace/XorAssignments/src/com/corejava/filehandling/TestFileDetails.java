package com.corejava.filehandling;

import java.io.*;

public class TestFileDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("file1.txt");
		System.out.println("File Name : "+file.getName());
		System.out.println("File Size in Bytes : "+file.length());
		System.out.println("File Path : "+file.getPath());
		System.out.println("File last Modified : "+file.lastModified());
		System.out.println("Permisions : "+file.canRead());
		System.out.println("Permisions : "+file.canExecute());
		System.out.println("Permisions : "+file.canWrite());
	}

}
