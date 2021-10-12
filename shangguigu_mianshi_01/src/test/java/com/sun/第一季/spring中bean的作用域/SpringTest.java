package com.sun.第一季.spring中bean的作用域;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by qiulisun on 2021/10/8.<br>
 */
public class SpringTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring中bean的作用域/bean1.xml");

    @Test
    public void testBook() {
        Book book1 = (Book) ioc.getBean("book");
        Book book2 = (Book) ioc.getBean("book");
        System.out.println(book1 == book2);
    }
}
