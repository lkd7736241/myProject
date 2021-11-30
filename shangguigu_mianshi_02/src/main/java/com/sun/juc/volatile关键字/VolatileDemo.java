package com.sun.juc.volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile的可见性和原子性验证
 * <p>
 * create by qiulisun on 2021/10/12.<br>
 */
public class VolatileDemo {
    public static void main(String[] args) {
//        volatileVisibilityDemo();
        volatileAtomicDemo();
    }

    /**
     * 验证volatile的原子性
     */
    private static void volatileAtomicDemo() {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.add();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 活跃线程数大于2，则让主线程等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value is : " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally atomicInteger value is : " + myData.atomicInteger);
    }

    /**
     * 验证volatile的可见性
     */
    private static void volatileVisibilityDemo() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            myData.setTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            // 若主线程没有得到通知，number的值已经改变，主线程就一直认为number值为0，一直在此处循环
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over, value is : " + myData.number);
    }
}

class MyData {
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void setTo60() {
        this.number = 60;
    }

    public void add() {
        this.number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}