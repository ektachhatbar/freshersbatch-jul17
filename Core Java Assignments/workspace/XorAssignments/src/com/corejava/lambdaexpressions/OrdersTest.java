package com.corejava.lambdaexpressions;

public class OrdersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orders<Double,Boolean> order1=(amt)->amt>10000?true:false;
		System.out.println(order1.testOrders(49273739.00));
		System.out.println(order1.testOrders(900.00));
		
		Orders<Boolean,String> order2=(val)->val==true?"Accepted":"Completed";
		System.out.println(order2.testOrders(true));
		System.out.println(order2.testOrders(false));
		
	}

}
