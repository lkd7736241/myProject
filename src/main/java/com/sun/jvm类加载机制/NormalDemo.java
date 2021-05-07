package com.sun.jvm类加载机制;

/**
 * create by qiulisun on 2020/12/3.<br>
 */
public class NormalDemo {
    public static void main(String[] args) {
        Class<?> clazz = NormalClass.class;
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClassLoader().getParent());
        System.out.println(clazz.getClassLoader().getParent().getParent());
    }
}

class NormalClass {
}