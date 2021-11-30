package com.sun.juc.线程通信;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 * 1. CyclicBarrier 字面意思是可循环使用的屏障。
 * 它要做的事情是，让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，屏障才会打开，所有被屏障拦截的线程才会继续干活
 * 2. 通过 CyclicBarrier的 await() 方法，使线程进入屏障
 * 3. CountDownLatch 是减，而 CyclicBarrier 是加，理解了CountDownLatch，CyclicBarrier 就很容易
 * <p>
 * create by qiulisun on 2021/10/20.<br>
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("收集齐7颗龙珠，召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第：" + temp + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
