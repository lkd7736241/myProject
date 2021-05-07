package com.sun.多线程.闭锁;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * A synchronization aid that allows one or more threads to wait
 * until a set of operations being performed in other threads completss
 * 允许一个或者多个线程一直等待，直到其他线程完成他们的工作
 * <p>
 * 原理：
 * 1. countDownLatch对象初始化时初始化count值；
 * 2. 创建一个线程对象，用countDownLatch对象调用await()方法，当count变为0时，该线程会继续执行；
 * 3. 创建其他线程，当调用countDown()方法时，count值会减1。
 * <p>
 * create by qiulisun on 2021/1/5.<br>
 *
 * @author 51050
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("现在6点下班了");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("..其他的5个员工走光了，终于可以走了");
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("员工Xxx现在下班了");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
