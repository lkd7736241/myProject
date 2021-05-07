package com.sun.多线程;

/**
 * create by qiulisun on 2020/11/24.<br>
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
