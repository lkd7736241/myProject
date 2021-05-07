package com.sun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by qiulisun on 2018/12/16.<br>
 * @author 51050
 */
public class UserProxyFactory {
    //目标对象
    private static Object target;

    //关注点代码的类
    private static Aop aop;

    public static Object getProxyInstance(Object target_, Aop aop_) {

        target = target_;
        aop = aop_;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop.begin();
                        Object value = method.invoke(target, args);
                        aop.close();
                        return value;
                    }
                });
    }
}
