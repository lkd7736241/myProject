package com.sun.juc.多线程中的锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（也就是递归锁）
 * <p>
 * 指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 * <p>
 * 也就是说，线程可以进入任何一个它已经拥有的锁所有同步着的代码块。
 * <p>
 * create by qiulisun on 2021/10/19.<br>
 */
public class RenenterLockDemo {
    public static void main(String[] args) {
//        renenterLock();

//        syncLock();
    }

    private static void syncLock() {
        MyPhone phone = new MyPhone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

    private static void renenterLock() {
        MyPhone phone = new MyPhone();
        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}

class MyPhone implements Runnable {
    // 锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    // get
    public void get() {
        lock.lock();
//        锁几次就必须释放几次，否则线程就会一直持有资源，造成程序卡死
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    // set
    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set()");
        } finally {
            lock.unlock();
        }
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendEmail");
    }
}
