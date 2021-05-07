package com.sun.proxy;

/**
 * create by qiulisun on 2018/12/15.<br>
 */
public class Student implements Person {
    @Override
    public void sing(String name) {
        System.out.println("student sing : " + name);
    }

    @Override
    public void dance(String name) {
        System.out.println("student dance : " + name);
    }
}
