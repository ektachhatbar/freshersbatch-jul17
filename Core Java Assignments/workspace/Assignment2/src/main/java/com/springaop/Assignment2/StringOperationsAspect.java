package com.springaop.Assignment2;

import java.security.Signature;
import java.util.HashMap;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.annotation.AfterThrowing;  
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;  

@Aspect
public class StringOperationsAspect {
    HashMap<org.aspectj.lang.Signature,Throwable> hmap=new HashMap<org.aspectj.lang.Signature,Throwable>();
	/*@Pointcut("execution(* StringOperations.getCapStr(..))*")
	public void string_pointcut(){}
	@AfterThrowing("string_pointcut()")*/
	@AfterThrowing(pointcut = "execution(* StringOperations.*(..))",throwing= "error") 
	public void stringAdvice(JoinPoint jp,Throwable error){
        hmap.put(jp.getSignature(), error);
        System.out.println("map "+hmap.entrySet());
	}
}
