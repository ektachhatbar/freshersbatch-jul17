package com.corejava.lambdaexpressions;

public class ArithmethicOperation{
	public static void main(String args[]){
		MathOperation<Integer> addition = (a,b) -> a + b; 
		System.out.println(addition.mathOPeration(10, 5));
		
		MathOperation<Integer> subtraction = (a,b) -> a - b; 
		System.out.println(subtraction.mathOPeration(10, 5));
		
		MathOperation<Integer> multiplication = (a,b) -> a * b; 
		System.out.println(multiplication.mathOPeration(10, 5));
		
		MathOperation<Double> division = (a,b) -> a / b; 
		System.out.println(division.mathOPeration(10.8, 5.2));
	}

	
}