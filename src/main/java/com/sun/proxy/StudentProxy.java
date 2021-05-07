package com.sun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by qiulisun on 2018/12/15.<br>
 * @author 51050
 */
public class StudentProxy {

    Student student = new Student();

    public Person getProxy() {

        /**
         * 参数一：代理类的类加载器
         * 参数二：被代理对象的接口
         * 参数三：InvocationHandler实现类
         */
        return (Person) Proxy.newProxyInstance(StudentProxy.class.getClassLoader(),
                student.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * proxy : 把代理对象自己传递进来
                     * method：把代理对象当前调用的方法传递进来
                     * args:把方法参数传递进来
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("给100万就唱");
                            method.invoke(student, args);
                        }
                        return null;
                    }
                }
                );
    }
}
