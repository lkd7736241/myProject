package com.sun.juc.多线程中的锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 自旋锁的好处：循环比较获取直到成功为止，没有类似wait的阻塞。
 * <p>
 * 通过CAS操作完成自旋锁：
 * A线程先进来调用lock方法自已持有锁3秒钟
 * B随后进来后发现当前有线程持有锁，不是null，
 * 所以只能通过自旋等待，直至A释放锁后B随后抢到
 * <p>
 * 线程 A 先执行，此时期望值为 null ，线程 A 将获得锁，并将期望值设置为线程 A 自身
 * 线程 B 尝试获取锁，发现期望值并不是 null ，就在那儿原地自旋
 * 线程 A 释放锁之后，将期望值设置为 null ，此时线程 B 获得锁，将期望值设置为线程 B 自身
 * 最后线程 B 释放锁
 * <p>
 * create by qiulisun on 2021/10/20.<br>
 */
public class SpinLockDemo {
    // 将Thread对象包装为原子引用
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }, "BB").start();
    }

    public void lock() {
        // 获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come in");
        // 自旋
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unLock() {
        // 获取当前线程
        Thread thread = Thread.currentThread();
        // 解锁当前线程
        atomicReference.compareAndSet(thread, null);

        System.out.println(thread.getName() + "\t invoke unlock");
    }
}
