package com.sun.juc.CAS算法;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS-比较并交换
 * <p>
 * create by qiulisun on 2021/10/14.<br>
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) +
                "\t currnt data is : " + atomicInteger);
        System.out.println(atomicInteger.compareAndSet(5, 1024) +
                "\t currnt data is : " + atomicInteger);
    }
}
