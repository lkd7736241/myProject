package com.sun.第一季.单例模式.懒汉式;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * create by qiulisun on 2021/10/6.<br>
 */
public class TestSingleton4 {
    @Test
    public void test() throws ExecutionException, InterruptedException {
//        Singleton4 s1 = Singleton4.getInstance();
//        Singleton4 s2 = Singleton4.getInstance();
//
//        System.out.println(s1 == s2);
//        System.out.println(s1);
//        System.out.println(s2);

        Callable callable = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(callable);
        Future<Singleton4> f2 = es.submit(callable);

        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();

        es.shutdown();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

    }
}
