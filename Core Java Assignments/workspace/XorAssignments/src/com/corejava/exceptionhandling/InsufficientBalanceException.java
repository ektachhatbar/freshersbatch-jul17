package com.corejava.exceptionhandling;

public class InsufficientBalanceException extends RuntimeException{ //Exception{
	private double withdrawAmount; 
	public InsufficientBalanceException() { 
		this.withdrawAmount = 0.0; 
	} 
	public InsufficientBalanceException(double withdrawAmount) { 
		this.withdrawAmount = withdrawAmount; 
	} 
	public String toString() { 
		return "Insufficient Balance and Entered amount is " + this.withdrawAmount; 
	}

}
