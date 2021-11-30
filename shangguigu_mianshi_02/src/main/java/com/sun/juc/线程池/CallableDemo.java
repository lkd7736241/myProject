package com.sun.juc.线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * create by qiulisun on 2021/10/23.<br>
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        new Thread(task, "AA").start();
        new Thread(task, "BB").start();
        int result01 = 100;
        // 等待线程执行完成
        while (!task.isDone()) {
            // do something here
        }
        // 要求获得callable线程的计算结果
        Integer result02 = task.get();
        System.out.println("result=" + (result01 + result02));
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable come in ...");
        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1024;
    }
}
