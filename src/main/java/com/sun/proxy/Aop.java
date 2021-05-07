package com.sun.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * create by qiulisun on 2018/12/15.<br>
 * @author 51050
 */
@Component
@Aspect
public class Aop {

    @Before("execution(* com.sun.proxy.UserDao.save(..))")
    public void begin() {
        System.out.println("开始事务");
    }

    @After("execution(* com.sun.proxy.UserDao.save(..))")
    public void close() {
        System.out.println("关闭事务");
    }
}
