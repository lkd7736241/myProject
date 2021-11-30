package com.sun.juc.多线程中的锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * <p>
 * 多个线程同时读一个资源类没有问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是写资源只能有一个线程。
 * 写操作：原子+独占，整个过程必须是一个完整的统一体，中间不许被分割，被打断。
 * 总结：
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 * <p>
 * create by qiulisun on 2021/10/20.<br>
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            Integer temp = i;
            new Thread(() -> {
                cache.put(temp.toString(), temp.toString());
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            Integer temp = i;
            new Thread(() -> {
                cache.get(temp.toString());
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    // 创建读写锁
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    // 用volatile修饰变量，使其对其他线程可见
    private volatile Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 写操作
     */
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入;" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 读操作
     */
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结果：" + o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
