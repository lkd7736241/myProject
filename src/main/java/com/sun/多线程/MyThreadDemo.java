package com.sun.多线程;

/**
 * create by qiulisun on 2020/11/24.<br>
 */
public class MyThreadDemo {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");

        thread1.start();
        Thread.sleep(1000);
        thread2.start();

        System.out.println(Thread.currentThread().getName());
    }
}
