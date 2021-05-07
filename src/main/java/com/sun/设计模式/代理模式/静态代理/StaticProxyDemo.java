package com.sun.设计模式.代理模式.静态代理;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        JavaProgrammer javaProgrammer = new JavaProgrammer();

        ProxyProgrammer proxyProgrammer = new ProxyProgrammer(javaProgrammer);

        proxyProgrammer.coding();
    }
}
