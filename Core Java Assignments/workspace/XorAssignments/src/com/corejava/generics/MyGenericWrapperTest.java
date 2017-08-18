package com.corejava.generics;

public class MyGenericWrapperTest {
	public static void main(String args[]) {
		MyGenericWrapper<Integer> wrap=new MyGenericWrapper<Integer>();
		wrap.set(new Integer(11));
		int i=wrap.get();
		System.out.println(i);
		wrap.inspect(9);
	}
}
