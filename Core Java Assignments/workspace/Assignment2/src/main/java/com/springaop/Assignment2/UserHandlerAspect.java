package com.springaop.Assignment2;

import java.util.Calendar;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
 
@Aspect
public class UserHandlerAspect {
 
     int loggedIn = 0;
     static double timeStart;
    
     @Around("execution(* com.spring.aop.UserHandler.login(..))")
     public boolean loginCheck(ProceedingJoinPoint  joinPoint) throws Throwable {
 
                Object[] args =  joinPoint.getArgs();
                if(args[0].toString().length()>=3)
                {
                     try {
                     Object loginstatus = joinPoint.proceed();
                    
                    
                      if(loginstatus.toString().equals("true"))
                     {  
                           loggedIn=1;
                           timeStart = Calendar.getInstance().get(Calendar.MILLISECOND);
                           return true;
                    
                      }else
                           return false;
                    
                     }catch(Exception e) {}
                }
          
                return false;
     }
    
    
     @After("execution (* com.spring.aop.UserHandler.logout(..))")
     public void logoutTimeNote() {
          
           System.out.println("Session lasted for "+(Calendar.getInstance().get(Calendar.MILLISECOND)-timeStart));
     }
    
    
    
     @AfterThrowing(pointcut="execution (* com.spring.aop.UserHandler.logout(..))",throwing="ex")
     public void logoutCheck(Exception ex) {
          
           System.out.println(ex);
           }
          
    
 
 
     @Around("execution(* com.spring.aop.UserHandler.register(..))")
     public void registerCheck(ProceedingJoinPoint jp) throws Throwable {
          
           Object[] args =  jp.getArgs();
           if(args[0].toString().length()>=3 && args[1].toString().length()>=3)
                jp.proceed();
           else
                System.out.println("Username and Password must be of min 3 letters");
     }
    
}
