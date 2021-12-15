package com.sun.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * create by qiulisun on 2021/12/3.<br>
 *
 * @author 51050
 */
public class AqsDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + " is come in");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + " is come in");
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + " is come in");
            } finally {
                lock.unlock();
            }
        }, "t3").start();
    }
}
