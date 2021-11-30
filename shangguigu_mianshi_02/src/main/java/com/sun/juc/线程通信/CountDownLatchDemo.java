package com.sun.juc.线程通信;

import java.util.concurrent.CountDownLatch;

/**
 * 门栓
 * 1. 让一些线程阻塞，直到另一些线程完成一系列操作后才被唤醒
 * 2. CountDownLatch 维护了一个计数器，有两个核心方法：countDown() 和 await()
 * (1) 调用 countDown() 方法会将计数器减一
 * (2) 当计数器的值不为零时，线程调用 await() 方法时，会被阻塞
 * (3) 当计数器的值变为0时，因调用 await() 方法被阻塞的线程会被唤醒，继续执行
 * create by qiulisun on 2021/10/20.<br>
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        schoolOver();
        getCountry();
    }

    private static void getCountry() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国被灭");
                countDownLatch.countDown();
            }, CountryEnum.list(i).getRetMsg()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦国统一华夏");
    }

    private static void schoolOver() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ****班长最后关门走人");
    }
}
