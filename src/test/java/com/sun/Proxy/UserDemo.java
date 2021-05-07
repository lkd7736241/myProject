package com.sun.Proxy;

import com.sun.proxy.IUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by qiulisun on 2018/12/16.<br>
 */
public class UserDemo {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        //动态代理手工实现aop
//        IUser iUser = (IUser) context.getBean("proxy");
//        iUser.save();

        //注解实现spring的aop
        IUser iUser = (IUser) context.getBean("userDao");
        System.out.println(iUser.getClass());
        iUser.save();
    }
}
