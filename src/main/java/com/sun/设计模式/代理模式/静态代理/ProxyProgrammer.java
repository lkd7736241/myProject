package com.sun.设计模式.代理模式.静态代理;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class ProxyProgrammer implements Programmer {
    private JavaProgrammer javaProgrammer;

    public ProxyProgrammer(JavaProgrammer javaProgrammer) {
        this.javaProgrammer = javaProgrammer;
    }

    public void vote() {
        System.out.println("平台引流");
    }

    @Override
    public void coding() {
        javaProgrammer.coding();
        vote();
    }
}
