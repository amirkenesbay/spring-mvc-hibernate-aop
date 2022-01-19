package com.amirkenesbay.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAdvice {
    @Around("execution(* com.amirkenesbay.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepository(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of: " + methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of: " + methodName);
        return targetMethodResult;
    }
}
