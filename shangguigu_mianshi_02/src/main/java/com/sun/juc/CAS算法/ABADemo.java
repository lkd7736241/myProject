package com.sun.juc.CAS算法;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题
 * <p>
 * create by qiulisun on 2021/10/15.<br>
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        // 演示ABA问题
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            // 这里睡眠是为了等t1线程的ABA操作完成
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean res = atomicReference.compareAndSet(100, 2021);
            System.out.println(res + "\t" + atomicReference.get());
        }, "t2").start();
    }
}

class ABADemo1 {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        // ABA问题的解决
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            int stamp1 = atomicStampedReference.getStamp();
            System.out.println(threadName + "\t 第一次版本号：" + stamp1);
            atomicStampedReference.compareAndSet(100, 101, stamp1, stamp1 + 1);
            int stamp2 = atomicStampedReference.getStamp();
            System.out.println(threadName + "\t 第二次版本号：" + stamp2);
            atomicStampedReference.compareAndSet(101, 100, stamp2, stamp2 + 1);
            System.out.println(threadName + "\t 第三次版本号：" + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "\t 第一次版本号：" + stamp);
            // 这里睡眠是为了等t3线程的ABA操作完成
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean res = atomicStampedReference.compareAndSet(100, 2020, stamp,
                    stamp + 1);
            System.out.println(threadName + "\t 修改是否成功：" + res + "\t 当前最新版本号：" + atomicStampedReference.getStamp() +
                    "\t 当前最新值：" + atomicStampedReference.getReference());
        }, "t4").start();
    }
}
