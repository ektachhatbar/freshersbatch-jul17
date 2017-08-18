package com.corejava.generics;

public class MyGenericWrapper<T> {
	T data;
	public void set(T data){
		this.data=data;
	}
	public T get(){
		return this.data;
	}
	public <U extends Number> void inspect(U u){        
		System.out.println(u);
	} 
}
