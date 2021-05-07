package com.sun.jvm类加载机制;

/**
 * create by qiulisun on 2020/12/3.<br>
 */
public class BootstrapDemo {
    public static void main(String[] args) {
        String message = "www.baidu.com";
        System.out.println(message.getClass().getClassLoader());
    }
}
