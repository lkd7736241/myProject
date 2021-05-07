package com.sun.设计模式.代理模式.动态代理_李宇春;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by qiulisun on 2020/12/17.<br>
 */
public class LiyuchunProxy {
    private Liyuchun liyuchun = new Liyuchun();

    public Idol createProxy() {
        /*
         * 第一个参数：为了产生某个对象的代理对象，需要一个类装载器。（固定写法）  代理类的类加载器
         * 第二个参数：产生谁的代理对象。（基于接口进行代理，所以要拿到接口）      被代理类的对象
         * 第三个参数：产生的代理对象干什么事情，什么事情是通过一个对象来指定的，也就是说这个地方必须要new一个InvocationHandler接口类型的对象
         */
        return (Idol) Proxy.newProxyInstance(LiyuchunProxy.class.getClassLoader(), liyuchun.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        if ("sing".equals(methodName)) {
                            System.out.println("收费一万块");
                            String invokeRes = (String) method.invoke(liyuchun, args);
                            return invokeRes;
                        } else if ("dance".equals(methodName)) {
                            System.out.println("收费两万块");
                            String invokeRes = (String) method.invoke(liyuchun, args);
                            return invokeRes;
                        } else {
                            System.out.println("没有这项服务");
                        }
                        return null;
                    }
                });

    }
}
