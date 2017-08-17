package com.corejava.exceptionhandling;

class Account{
	private int accountId;
	private String accountName;
	private double accountBalance;
	Account(int accountId,String accountName,double accountBalance){
		this.accountId=accountId;
		this.accountName=accountName;
		this.accountBalance=accountBalance;
	}
	public void withdraw(double accBal)throws InsufficientBalanceException{
		if(accBal>this.accountBalance)
			throw new InsufficientBalanceException(accBal);
		this.accountBalance=this.accountBalance-accBal;
	}
	public void deposit(double accBal){
		this.accountBalance=this.accountBalance+accBal;
	}
	public void print(){
		System.out.println(" Account-Id : "+this.accountId+" Account-Name : "+this.accountName+" Account-Balance : "+this.accountBalance);	
	}
}