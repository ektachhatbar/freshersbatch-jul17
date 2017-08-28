package com.corejava.filehandling;

import java.io.*;

public class RandomAccessFileTest {

	public static void main(String args[]) throws Exception{
		int ch,option,account_id;
		String dob;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		File file= new File("UserAccounts.txt");
   		RandomAccessFile raf= new RandomAccessFile(file, "rw");
		do{
		System.out.println("ACCOUNT");
		System.out.println("1. Create Account");
		System.out.println("2. Read Account details");
		System.out.println("3. Update Account");
		System.out.println("4. Delete Account");
		System.out.println("Enter your choice:");
		option=Integer.parseInt(br.readLine());
		switch(option){
			case 1: System.out.println("Enter Account Id\n");
			   		account_id=Integer.parseInt(br.readLine());
			   		System.out.println("Enter Date\n");
			   		dob=br.readLine();
			   		raf.writeInt(account_id);
			   		raf.writeUTF(dob);
			   		
			   		long currentPositionToCreate= raf.getFilePointer();
			   		raf.seek(0);
			   		
					break;
					
					
			case 2: long currentPositionToRead= raf.getFilePointer();
					
					try{
						raf.seek(0);
					do{	
	   				
	   				int id = raf.readInt();
	   				String date = raf.readUTF();
	   				raf.readLine();
	   				System.out.println("\n Your Id : "+id+" and date of birth is "+ date);
					}while(true);
					}catch(Exception e){
						System.out.println("");
					}
					break;
			case 3: 
					break;
			case 4: 
					break;
			default: 
					break;
		}
		System.out.println("\nDo you want to continue (Type 1) \n");
	    ch = Integer.parseInt(br.readLine());;    
	   } while (ch == 1);
	}
}
