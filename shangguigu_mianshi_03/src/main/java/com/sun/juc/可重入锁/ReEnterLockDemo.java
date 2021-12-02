package com.sun.juc.可重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
 * 在一个synchronized修饰的方法或代码块的内部调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 * create by qiulisun on 2021/12/2.<br>
 *
 * @author 51050
 */
public class ReEnterLockDemo {
    static Object obj = new Object();

    static Lock lock = new ReentrantLock();

    private static void m2() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("====外层调用");
                lock.lock();
                try {
                    System.out.println("====中层调用");
                    lock.lock();
                    try {
                        System.out.println("====内层调用");
                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    private static void m1() {
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("====外层调用");
                synchronized (obj) {
                    System.out.println("====中层调用");
                    synchronized (obj) {
                        System.out.println("====内层调用");
                    }
                }
            }
        }, "t1").start();
    }

    public static void main(String[] args) {
//        m1();
        m2();
    }

}
