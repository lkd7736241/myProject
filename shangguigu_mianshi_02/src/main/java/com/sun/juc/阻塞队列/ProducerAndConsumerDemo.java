package com.sun.juc.阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 队列传统的使用方式 - 生产者消费者模型
 * <p>
 * 1. 线程操作资源类       --》编写方法
 * 2. 判断 干活 通知唤醒   --》await()和 signalAll()
 * 3. 防止虚假唤醒机制     --》使用while判断，而不是if
 * <p>
 * create by qiulisun on 2021/10/21.<br>
 */
public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        }, "BBB").start();
    }
}

/**
 * 资源类
 */
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            // 1 判断
            while (number == 1) {
                // 等待，不能生产
                condition.await();
            }
            // 2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            // 1. 判断
            while (number == 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2. 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3. 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
