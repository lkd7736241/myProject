package com.sun.juc.集合线程不安全;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类线程不安全问题
 * 1. 故障现象
 * java.util.ConcurrentModificationException
 * <p>
 * 2. 故障原因
 * 由于线程争抢资源（类似多人争抢往一张纸上写东西）
 * <p>
 * 3. 解决方案
 * list
 * （1）使用Vector(),每个线程都加synchronized,缺点是会导致并发性下降
 * （2）使用Collections.synchornizedList(new ArrayList<>()),转换成线程安全类
 * （3）使用new CopyOnWriteArrayList()
 * <p>
 * set
 * (1) 使用 Collections.synchronizedSet() 方法将 HashSet 转为线程安全版本
 * (2) 使用 CopyOnWriteArraySet 类：读写分离
 * map
 * (1) 使用concurrnetHashMap 分段上锁
 * <p>
 * 4. 优化建议
 * <p>
 * create by qiulisun on 2021/10/16.<br>
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        setNotSafe();
//        setSafeWhitSynchronizedSet();
//        setSafeWithCopyOnWriteArraySet();

//        mapNotSafe();
        mapSafeWithConcurrentHashMap();
    }

    private static void mapSafeWithConcurrentHashMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + map);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * map线程不安全代码
     */
    private static void mapNotSafe() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + map);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 使用CopyOnWriteArraySet保证线程安全
     */
    private static void setSafeWithCopyOnWriteArraySet() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + set);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 使用synchronizedSet保证线程安全
     */
    private static void setSafeWhitSynchronizedSet() {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + set);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * set不安全代码
     */
    private static void setNotSafe() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + set);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 使用CopyOnWriteArrayList保证线程安全
     */
    private static void listSafeWithCopyOnWriteArrayList() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 使用synchorizedList保证线程安全
     */
    private static void listSafeWithSynchorizedList() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 使用vector保证线程安全
     */
    private static void listSafeWithVector() {
        Vector<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * list不安全代码
     */
    private static void listNotSafe() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + list);
            }, String.valueOf(i)).start();
        }
    }
}
