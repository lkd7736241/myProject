package com.sun.设计模式.代理模式.动态代理;

import java.lang.reflect.Proxy;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class DynaProxyDemo {
    public static void main(String[] args1) {
        DynaJavaProgrammer programmer = new DynaJavaProgrammer();

        DynaProxyProgammer proxyProgrammer = (DynaProxyProgammer) Proxy.newProxyInstance(
                DynaProxyProgammer.class.getClassLoader(), programmer.getClass().getInterfaces(), (proxy, method, args) -> {
                    if ("coding".equals(method.getName())) {
                        return method.invoke(programmer, args);
                    } else {
                        return method.invoke(programmer, args);
                    }
                });
        proxyProgrammer.codeing();
    }
}
