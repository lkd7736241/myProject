package com.sun.设计模式.代理模式.透明代理;

/**
 * 可以看出代理类只代理一个类的对象，所以他代理的对象对外界来说是透明的
 * <p>
 * create by qiulisun on 2020/12/16.<br>
 */
public class TransparentProxyDemo {
    public static void main(String[] args) {
        TransparentProxyProgrammer proxyProgrammer = new TransparentProxyProgrammer();

        proxyProgrammer.coding();
    }
}
