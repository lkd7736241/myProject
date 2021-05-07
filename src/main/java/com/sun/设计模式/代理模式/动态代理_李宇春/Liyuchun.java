package com.sun.设计模式.代理模式.动态代理_李宇春;

/**
 * create by qiulisun on 2020/12/17.<br>
 */
public class Liyuchun implements Idol {
    @Override
    public String sing(String name) {
        System.out.println("李宇春唱歌:" + name);
        return "唱完了";
    }

    @Override
    public String dance(String name) {
        System.out.println("李宇春跳舞:" + name);
        return "跳完了";
    }
}
