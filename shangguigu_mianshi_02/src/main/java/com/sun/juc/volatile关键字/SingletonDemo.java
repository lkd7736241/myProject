package com.sun.juc.volatile关键字;

/**
 * volatile在单例模式中的作用
 * <p>
 * create by qiulisun on 2021/10/13.<br>
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println("我是线程" + Thread.currentThread().getName() + "的初始化方法");
    }

    /**
     * double check lock 机制
     *
     * @return
     */
    public static SingletonDemo getInstance03() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static SingletonDemo getInstance01() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public static synchronized SingletonDemo getInstance02() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance03();
            }, String.valueOf(i)).start();
        }
    }
}
