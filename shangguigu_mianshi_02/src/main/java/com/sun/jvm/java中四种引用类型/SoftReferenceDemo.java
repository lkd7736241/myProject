package com.sun.jvm.java中四种引用类型;

import java.lang.ref.SoftReference;

/**
 * 软引用示例
 * <p>
 * create by qiulisun on 2021/10/26.<br>
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
//        soft_memory_enough();

        soft_memory_notEnough();
    }

    /**
     * 内存不充足的情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    private static void soft_memory_notEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    /**
     * 内存充足的情况
     */
    private static void soft_memory_enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        // 进行GC（垃圾回收）
        System.gc();
        // 此时强引用的普通对象被回收，而软引用因为内存任然充足，没有被回收
        System.out.println(o1);
        System.out.println(softReference.get());
    }
}
