package com.corejava.lambdaexpressions;

import java.util.Random;
import java.util.function.*;

public class BuiltInFunctionalInterfacesTest {
	public static void printGrade(Supplier<Integer> supplier){  
		Integer marks =(Integer) supplier.get();  
		if(marks>50){
			System.out.println(marks+" Pass");
		}else{
			System.out.println(marks+" Fail");
		}
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		System.out.println(nonEmptyStringPredicate.test("hey"));

		Consumer<Integer> consumer = (Integer x) -> System.out.println(x);
		consumer.accept(9);
		
		Random random=new Random();
		Supplier<Integer> supplier = () -> random.nextInt(100); 
		printGrade(supplier); 
		
		Function<Integer, String> function = (Integer marks)->marks > 40 ? "PASS" : "FAILED"; 
		System.out.println("Result = " + function.apply(45)); 
		System.out.println("Result = " + function.apply(23)); 
	}
}
