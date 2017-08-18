package com.corejava.lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceStringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("sb");
		list.add("tbc");
		list.add("wbcd");
		StringBuilder sb=new StringBuilder();
		for(String s:list){
			sb.append(s.substring(0,1));
		}
		Consumer<StringBuilder> consumer = (StringBuilder x) -> System.out.println(x);
		consumer.accept(sb);
	}

}
