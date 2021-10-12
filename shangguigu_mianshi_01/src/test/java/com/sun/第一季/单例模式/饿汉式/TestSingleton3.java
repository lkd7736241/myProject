package com.sun.第一季.单例模式.饿汉式;

import org.junit.Test;

/**
 * create by qiulisun on 2021/10/6.<br>
 */
public class TestSingleton3 {
    @Test
    public void test() {
        String info = Singleton3.INSTANCE.getInfo();
        System.out.println(info);
    }
}
