package com.sun.juc.lockSupport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * create by qiulisun on 2021/12/2.<br>
 *
 * @author 51050
 */
public class LockSupportDemo {
    static Object obj = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    /**
     * 使用LockSupport类中的park()与unpark()方法实现线程的等待/唤醒
     */
    private static void parkUnpark() {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "=========come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "=========被唤醒");
        }, "t1");
        t1.start();


        new Thread(() -> {
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "========通知");
        }, "t2").start();
    }

    /**
     * Condition接口中的await后signal方法实现线程的等待和唤醒
     */
    private static void conAwaitSignal() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "===========come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "=============被唤醒");
            } finally {
                lock.unlock();
            }
        }, "t1").start();


        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "=======通知");
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    /**
     * 使用 wait()和notify()方法来阻塞/唤醒线程
     * wait和notify方法必须要在同步块或者方法里面且成对出现使用
     * 先wait后notify才行
     */
    private static void syncWaitNotify() {
        new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "\t" + "=======come in");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "==========被唤醒");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (obj) {
                obj.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "=========通知");
            }
        }, "t2").start();
    }

    public static void main(String[] args) {
//        syncWaitNotify();
//        conAwaitSignal();
        parkUnpark();
    }
}
