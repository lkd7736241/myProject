package com.sun.juc.volatile关键字;

import org.junit.Test;

/**
 * create by qiulisun on 2021/10/13.<br>
 */
public class TestSingletonDemo {
    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance01();
            }, String.valueOf(i)).start();
        }
    }
}
