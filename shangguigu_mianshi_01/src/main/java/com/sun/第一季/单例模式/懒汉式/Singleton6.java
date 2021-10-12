package com.sun.第一季.单例模式.懒汉式;

/**
 * 懒汉式实现（利用静态内部类，线程安全）
 * <p>
 * 1. 在内部类被加载和初始化时才会创建其中的实例
 * 2. 静态内部类不会随着外部类创建而创建，而是当被调用时才会创建和加载
 * 3. 类加载器是线程安全的，内部类的创建是线程安全的，其中的实例也是线程安全的
 * <p>
 * create by qiulisun on 2021/10/6.<br>
 */
public class Singleton6 {
    private Singleton6() {
    }

    private static class Inner {
        private static final Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.instance;
    }
}
