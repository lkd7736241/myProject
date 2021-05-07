package com.sun.Proxy;

import com.sun.proxy.Person;
import com.sun.proxy.StudentProxy;

/**
 * create by qiulisun on 2018/12/15.<br>
 */
public class StudentDemo {
    public static void main(String[] args){

        StudentProxy studentProxy = new StudentProxy();
        Person proxy = studentProxy.getProxy();
        proxy.sing("i love you");
    }
}
