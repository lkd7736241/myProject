package com.sun.jvm.java中四种引用类型;

import java.lang.ref.WeakReference;

/**
 * 弱引用示例
 * <p>
 * create by qiulisun on 2021/10/26.<br>
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("----------");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
