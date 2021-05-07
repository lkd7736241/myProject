package com.sun.多线程.信号量;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo(信号量)
 * 信号量实际上就是可以控制同时访问（一段代码）的线程个数，它维护了一组“许可证”
 * 当调用acquire()方法时，会消费一个许可证。如果没有许可证了，会阻塞起来
 * 当调用release()方法时，会添加一个许可证。
 * <p>
 * create by qiulisun on 2021/1/7.<br>
 *
 * @author 51050
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int num = 50;

        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < num; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("顾客" + finalI + "在挑选商品，购买。。。");
                    Thread.sleep(1000);
                    System.out.println("顾客" + finalI + "购买完毕了");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
