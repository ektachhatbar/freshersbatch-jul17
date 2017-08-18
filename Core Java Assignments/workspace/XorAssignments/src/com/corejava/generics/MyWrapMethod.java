package com.corejava.generics;

import java.util.*;

public class MyWrapMethod {
	public void process(List<? extends Number> list) {  
		System.out.println(list);
	} 
}
