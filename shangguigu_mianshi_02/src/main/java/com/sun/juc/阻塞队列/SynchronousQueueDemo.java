package com.sun.juc.阻塞队列;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue
 * <p>
 * 1. SynchronousQueue没有容量。与其他BlockingQueue不同，SynchronousQueue是一个不存储元素的BlockingQueue
 * 2. 每一个put操作必须要等待一个take操作，否则不能继续添加元素，反之亦然
 * 3. 一句话总结：SynchronousQueue 是零库存阻塞队列
 * <p>
 * create by qiulisun on 2021/10/21.<br>
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
