package com.sun.多线程.栅栏;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏(CyclicBarrier)
 * 允许一组线程相互等待，直到达到某个公共屏障点。
 * 注：这一对象可以被重用
 * <p>
 * create by qiulisun on 2021/1/7.<br>
 *
 * @author 51050
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                if ("Thread-0".equals(name)) {
                    name = "3y";
                } else {
                    name = "女朋友";
                }
                System.out.println(name + "到了体育馆");
                try {
                    // 两个人都到了体育西就发微博
                    cyclicBarrier.await();
                    System.out.println("跟" + name + "一起去吃东西吧");
                    // 回家然后洗澡
                    cyclicBarrier.await();
                    System.out.println(name + "到家了，洗澡先");
                    // 洗完澡后一起聊天
                    cyclicBarrier.await();
                    System.out.println("一起聊天");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
