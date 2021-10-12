package com.sun.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * create by qiulisun on 2021/9/26.<br>
 */
@Component
@Aspect
public class MyAspect {

    @Before("execution(public int com.sun.spring.impl.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("*** @Before我是前置通知");
    }

    @After("execution(public int com.sun.spring.impl.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("*** @after我是后置通知");
    }

    @AfterReturning("execution(public int com.sun.spring.impl.CalcServiceImpl.*(..))")
    public void afterReturnNotify() {
        System.out.println("*** @afterReturn 我是返回后通知");
    }

    @AfterThrowing("execution(public int com.sun.spring.impl.CalcServiceImpl.*(..))")
    public void afterThrowingNotify() {
        System.out.println("*** @afterThrowing 我是异常通知");
    }

    @Around("execution(public int com.sun.spring.impl.CalcServiceImpl.*(..))")
    public Object aroundNotify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object value = null;
        System.out.println("我是环绕通知之前AAA");
        value = proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知之后BBB");
        return value;
    }
}
