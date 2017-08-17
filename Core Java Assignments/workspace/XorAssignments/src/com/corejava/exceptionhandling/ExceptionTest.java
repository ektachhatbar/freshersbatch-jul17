package com.corejava.exceptionhandling;

public class ExceptionTest {

	public static void main(String[] args) {
		try { 
			int x=5;
			int y=0;
			System.out.println("Getting division"); 
			int division = x / y; 
			System.out.println("Division = "+ division); 
			try {
				int ary[] = new int[5]; ary[7] = 34;
			}catch(ArrayIndexOutOfBoundsException e){ 
				e.printStackTrace(); 
			}
		}catch(ArithmeticException e) {
			e.printStackTrace(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
		finally{
			System.out.println("Close");
		}
		try{
			int x=5;
			int y=0;
			System.out.println("Getting division"); 
			int division = x / y; 
			System.out.println("Division = "+ division); 
		}finally{
			System.out.println("Close 2");
		}
		try{
			System.exit(0);
		}finally{
			System.out.println("Close 3");
		}
	}

}
