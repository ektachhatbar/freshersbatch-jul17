package com.corejava.annotations;

public class Test extends AnnotationTest{
	
	@Override
	public void show(){
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
		AnnotationTest.print();
	}
}
