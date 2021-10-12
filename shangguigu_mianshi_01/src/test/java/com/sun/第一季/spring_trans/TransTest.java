package com.sun.第一季.spring_trans;

import com.sun.第一季.spring_trans.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * create by qiulisun on 2021/10/10.<br>
 */
public class TransTest {
    // 创建IOC容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("config/beans-tx.xml");

    @Test
    public void testCashier() {
        Cashier cashier = (Cashier) ioc.getBean("cashier");
        List<Integer> isbns = new ArrayList<>();
        isbns.add(1001);
        isbns.add(1002);
        cashier.checkOut(1, isbns);
    }
}
