package com.sun.jvm.oom_内存溢出;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * java.lang.OutOfMemoryError:Metaspace
 * <p>
 * 1. Metaspace是方法区在Hotspot中的实现，它与永久代最大的区别在于：Metaspace并不在虚拟机内存中而是使用本地内存，也即在java8中，classe metadata(the virtual
 * machines internal presentation of Java class)，被存储在叫做Metaspace的native memory
 * 2. Java 8及之后的版本使用Metaspace来替代永久代永久代，存放了以下信息:
 * (1) 虚拟机加载的类信息
 * (2) 常量池
 * (3) 静态变量
 * (4) 即时编译后的代码缓存
 * <p>
 * 模拟Metaspace空间溢出，我们不断生成类往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小的
 * <p>
 * create by qiulisun on 2021/10/27.<br>
 */
public class MetaspaceOOMDemo {
    public static void main(String[] args) {
        int i = 0;

        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OomDemo.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("******多少次后发生了异常：" + i);
            e.printStackTrace();
        }
    }

    static class OomDemo {

    }
}
