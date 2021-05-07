package com.sun.设计模式.代理模式.动态代理;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class DynaProxyProgammer implements DynaProgrammer {
    private DynaJavaProgrammer programmer;

    public DynaProxyProgammer(DynaJavaProgrammer programmer) {
        this.programmer = programmer;
    }

    @Override
    public void codeing() {
        programmer.codeing();
        System.out.println("平台引流");
    }
}
