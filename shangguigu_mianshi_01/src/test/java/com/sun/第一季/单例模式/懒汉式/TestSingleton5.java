package com.sun.第一季.单例模式.懒汉式;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * create by qiulisun on 2021/10/6.<br>
 */
public class TestSingleton5 {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Callable callable = new Callable<Singleton5>() {
            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = es.submit(callable);
        Future<Singleton5> f2 = es.submit(callable);

        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();

        es.shutdown();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }

}
