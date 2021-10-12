package com.sun.第一季.单例模式.懒汉式;

/**
 * 懒汉式实现（线程不安全）
 * 1）私有化构造方法
 * 2）用静态变量保存实例
 * 3）提供一个静态方法，这个方法向外界提供这个实例
 * <p>
 * 注意：现在是线程不安全的
 * <p>
 * create by qiulisun on 2021/10/6.<br>
 */
public class Singleton4 {
    private Singleton4() {
    }

    private static Singleton4 instance;

    public static Singleton4 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Singleton4();
        }
        return instance;
    }
}
