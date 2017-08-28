package com.springaop.Assignment2;

import java.util.*;

public class Adder {
	public void addInVector(){
		Vector<Integer> intVector=new Vector<Integer>();
		for(int i=1;i<1000;i++){
			intVector.addElement(i);
		}
	}
	public void addInList(){
		List<Integer> intList=new ArrayList<Integer>();
		for(int i=1;i<1000;i++){
			intList.add(i);
		}
	}
}
