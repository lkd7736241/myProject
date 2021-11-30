package com.sun.juc.线程通信;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * 1. Semaphore 即信号量，信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * 2. 构造器 Semaphore(int) 用于指定共享资源的数目，如果设定为 1 ，则 Semaphore 信号量退化为 Lock锁或者 synchronized锁
 * 3. 调用 semaphore.acquire() 方法获取对共享资源的使用，调用 semaphore.release() 释放对共享资源的占用
 * 4. 类似于抢车位
 * <p>
 * create by qiulisun on 2021/10/20.<br>
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒，释放车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
