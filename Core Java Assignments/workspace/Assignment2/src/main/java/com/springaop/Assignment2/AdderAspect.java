package com.springaop.Assignment2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdderAspect {
	@Pointcut("execution(* Adder.*(..))")
	public void adder_pointcut(){}
	@Around("adder_pointcut()")
	public Object time(ProceedingJoinPoint pjp)throws Throwable{
		Object args[]=pjp.getArgs();
		long startTime=System.currentTimeMillis();
		Object obj=pjp.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println("Time : "+(endTime - startTime));
		return obj;
	}
}
