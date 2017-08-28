package com.springaop.Assignment2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserHandlerAspect {
	@Pointcut("execution(* UserHandler.*(..))")
	public void user_pointcut(){}
	
	
}
