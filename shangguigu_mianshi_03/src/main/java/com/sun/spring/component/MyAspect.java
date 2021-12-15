package com.sun.spring.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 不同的spring版本，通知的执行顺序不相同
 * spring4(springboot1.X.X)：环绕前->before->调用方法->环绕后->after->after_return
 * spring5(springboot2.X.X): 环绕前->before->调用方法->after_return->after->环绕后
 * <p>
 * spring4(springboot1.X.X): 环绕前->before->after->after_throwing->报错
 * spring5(springboot2.X.x): 环绕前->before->after_throwing->after->报错
 * <p>
 * create by qiulisun on 2021/12/15.<br>
 *
 * @author 51050
 */
@Component
@Aspect
public class MyAspect {
    @Before("execution(public int com.sun.spring.service.impl.CalcServiceImpl.*(..))")
    public void beforeNotity() {
        System.out.println("===== before 前置通知======");
    }

    @After("execution(public int com.sun.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterNotity() {
        System.out.println("===== after 后置通知======");
    }

    @AfterReturning("execution(public int com.sun.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterReturnNotity() {
        System.out.println("===== after_Return 返回后通知======");
    }

    @AfterThrowing("execution(public int com.sun.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterThrowingNotity() {
        System.out.println("===== throw 异常通知======");
    }

    @Around("execution(public int com.sun.spring.service.impl.CalcServiceImpl.*(..))")
    public Object aroundNotity(ProceedingJoinPoint point) throws Throwable {
        Object obj = null;
        System.out.println("环绕通知之前===");
        obj = point.proceed();
        System.out.println("环绕通知之后===");
        return obj;
    }
}
