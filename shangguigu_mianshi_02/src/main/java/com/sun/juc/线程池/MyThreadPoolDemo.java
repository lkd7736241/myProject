package com.sun.juc.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * create by qiulisun on 2021/10/24.<br>
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println("custom thread pool \n");
        threadPool();
    }

    private static void threadPool() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );

        try {
            for (int i = 1; i <= 9; i++) {
                final int temp = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务" + temp);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
