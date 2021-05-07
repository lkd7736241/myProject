package com.sun.Proxy;

import com.sun.proxy.ProxyFactory;
import com.sun.proxy.Student;

/**
 * create by qiulisun on 2018/12/15.<br>
 */
public class CGLibProxyDemo {
    public static void main(String[] args){

        Student student = new Student();
        Student factory = (Student) new ProxyFactory(student).getProxyInstance();
        factory.sing("sunqiuli");
    }
}
