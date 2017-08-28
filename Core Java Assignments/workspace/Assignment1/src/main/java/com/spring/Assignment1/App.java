package com.spring.Assignment1;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("Beans_simple.xml");

    /*	double totalPrice=0.0;
    	HashMap<String,OrderBean> orders=(HashMap)iocContainer.getBeansOfType(OrderBean.class);
    	for(OrderBean o:orders.values()){
    		totalPrice=totalPrice+o.getItembean().getItemprice();
    	}
    	System.out.println("Total Price : "+totalPrice);*/
    	//ChatroomBean cb=(ChatroomBean)iocContainer.getBean("chatRoomBean");
    	/*HashMap<String,ChatroomBean> chat=(HashMap)iocContainer.getBeansOfType(ChatroomBean.class);
    	for(ChatroomBean cb:chat.values()){
	    	System.out.println("chatroom name : "+cb.getChatRoomName());
	    	System.out.println("\tUsers : "+cb.getUserbean());
	    	System.out.println("\tMessages : "+cb.getMessages());*/
    	
    	EmployeeBean bean=(EmployeeBean)iocContainer.getBean("employee");
    	System.out.println(bean.getDeptBean().getDeptName());
    	}
 }

