package com.sun.设计模式.代理模式.透明代理;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class TransparentProxyProgrammer implements TransparentProgrammer {

    private TransparentJavaProgrammer programmer;

    public TransparentProxyProgrammer() {
        this.programmer = new TransparentJavaProgrammer();
    }

    public void vote() {
        System.out.println("平台引流");
    }

    @Override
    public void coding() {
        programmer.coding();
        vote();
    }
}
