package com.corejava.annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

class Employee
{
	int ID;
	String name;
	int ABC;
	
	@Getter
	public int getID() {
		return ID;
	}

	@Getter
	public int getAge() {
		return 5;
	}
	
	@Getter
	public String getName() {
		return name;
	}
	
	@Getter
	public String getABC() {
		return "hi";
	}
	
	public void print()
	{
		System.out.println("In print method");
	}

	
}

