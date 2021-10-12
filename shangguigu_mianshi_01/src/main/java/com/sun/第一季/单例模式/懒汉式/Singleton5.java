package com.sun.第一季.单例模式.懒汉式;

/**
 * 懒汉式实现（线程安全）
 * 1）私有化构造器
 * 2）用静态变量保存唯一实例
 * 3）提供一个静态方法，用于向外提供唯一实例
 * <p>
 * create by qiulisun on 2021/10/6.<br>
 */
public class Singleton5 {
    private Singleton5() {
    }

    private volatile static Singleton5 instance;

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }
        }

        return instance;
    }
}
