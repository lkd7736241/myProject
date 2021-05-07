package com.sun.多线程;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * create by qiulisun on 2020/11/26.<br>
 */
public class 交替打印_AtomicInteger {
    static AtomicInteger threadNo = new AtomicInteger(1);

    public static void main(String[] args) {
        char[] chars1 = "123456".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : chars1) {
                while (threadNo.get() != 1) {
                }
                System.out.println(c);
                threadNo.set(2);
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : chars2) {
                while (threadNo.get() != 2) {
                }
                System.out.println(c);
                threadNo.set(1);
            }
        }, "t2").start();
    }
}
