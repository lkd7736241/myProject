package com.sun.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * create by qiulisun on 2018/12/15.<br>
 * @author 51050
 */
public class ProxyFactory implements MethodInterceptor {

    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务。。。。");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        System.out.println("提交事务。。。。");
        return returnValue;
    }

    //给目标对象创建代理对象
    public Object getProxyInstance() {

        //1.工具类(增强器)
        Enhancer enhancer = new Enhancer();
        //2.设置目标类（cglib的原理应该是创建一个目标类的子类以实现增强）
        enhancer.setSuperclass(target.getClass());
        //3.设置回调对象
        enhancer.setCallback(this);
        //4.创建子类对象（代理对象）
        return enhancer.create();
    }
}
