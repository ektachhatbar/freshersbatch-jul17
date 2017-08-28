package com.springaop.Assignment2;

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
    	AbstractApplicationContext iocContainer= new ClassPathXmlApplicationContext("beans_aop.xml");
    	/*StringOperations strOp=(StringOperations)iocContainer.getBean("stringOperationBean");
    	String s="";
    	try{  
            s=strOp.getCapStr("");
            System.out.println("String to Upper : "+s);
        }catch(Exception e){}  
         
    	try{  
            s=strOp.getLowerStr("");
            System.out.println("String to Lower: "+s);  
        }catch(Exception e){} 
    	try{  
            int len=strOp.getLength("");
            System.out.println("String Length: "+len);  
        }catch(Exception e){} */
    	Adder a=(Adder)iocContainer.getBean("adderBean");
    	a.addInList();
    	a.addInVector();
    }
}
