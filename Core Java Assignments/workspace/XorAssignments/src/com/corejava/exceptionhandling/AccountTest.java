package com.corejava.exceptionhandling;

public class AccountTest {

	public static void main(String[] args) throws InsufficientBalanceException{
		// TODO Auto-generated method stub
		Account account=new Account(123,"xyz",5000);
		System.out.println("Account Information : ");
		account.print();
		
		//try { 
			account.withdraw(6000);
			System.out.println("After Withdrawing : ");
			account.print();
		//}catch(InsufficientBalanceException e){ 
		//	e.printStackTrace(); 
		//}

	}

}
