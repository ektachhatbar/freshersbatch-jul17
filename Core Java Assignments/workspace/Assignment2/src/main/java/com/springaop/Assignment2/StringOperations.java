package com.springaop.Assignment2;

public class StringOperations {
	
	public String getCapStr(String str) throws Exception{
		if(str.isEmpty()){
			throw new Exception("String is empty");
		}else{
			return str.toUpperCase();
		}
	}
	public String getLowerStr(String str) throws Exception{
		if(str.isEmpty()){
			throw new Exception("String is empty");
		}else{
			return str.toLowerCase();
		}
	}
	public int getLength(String str)throws Exception{
		if(str.isEmpty()){
			throw new Exception("String is empty so can't calculate length");
		}else{
			return str.length();
		}
	}
}
