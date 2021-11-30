package com.sun.juc.阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程交替打印，展示 Lock 的精确唤醒
 * <p>
 * 多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * 。。。。
 * 打印10轮
 * <p>
 * create by qiulisun on 2021/10/22.<br>
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            shareResource.print_A_5();
        }, "A").start();

        new Thread(() -> {
            shareResource.print_B_10();
        }, "B").start();

        new Thread(() -> {
            shareResource.print_C_15();
        }, "C").start();
    }
}

class ShareResource {
    // A:1; B:2; C:3;
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition ca = lock.newCondition();
    private Condition cb = lock.newCondition();
    private Condition cc = lock.newCondition();

    public void print_A_5() {
        lock.lock();
        try {
            // 1. 判断
            while (number != 1) {
                ca.await();
            }
            // 2. 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3. 通知唤醒
            number = 2;
            cb.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print_B_10() {
        lock.lock();
        try {
            // 1. 等待
            while (number != 2) {
                cb.await();
            }
            // 2. 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3. 通知唤醒
            number = 3;
            cc.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print_C_15() {
        lock.lock();
        try {
            // 1. 等待
            while (number != 3) {
                cc.await();
            }
            // 2. 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3. 通知唤醒下一线程
            number = 1;
            ca.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}