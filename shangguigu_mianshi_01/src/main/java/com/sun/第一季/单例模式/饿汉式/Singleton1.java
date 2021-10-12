package com.sun.第一季.单例模式.饿汉式;

/**
 * 单例模式的实现要点：1. 某个类智能有一个实例；2. 它必须自行创建该示例；3. 它必须向整个系统提供这个实例
 * 1）直接实例化饿汉式
 * create by qiulisun on 2021/10/5.<br>
 */
public class Singleton1 {
    /**
     * 1. 构造器私有化
     * 2. 自行创建，并且用静态变量保存
     * 3. 向外提供实例
     * 4. 强调这是一个单例，用final标记
     */
    public static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }
}
