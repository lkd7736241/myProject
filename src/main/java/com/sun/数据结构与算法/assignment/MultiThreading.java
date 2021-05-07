package com.sun.数据结构与算法.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 景区游客
 * create by qiulisun on 2018/12/26.<br>
 */
public class MultiThreading {

    public static void main(String[] args){

        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3,
                100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

//        Random random = new Random();

        List<MyVisitor> visitors = new ArrayList<MyVisitor>();

        for (int i = 0; i < 10; i++) {
            MyVisitor visitor = new MyVisitor(i);
            visitors.add(visitor);
        }

        while (true){
            for (int i = 0; i < visitors.size(); i++) {
                executor.execute(visitors.get(i));
            }
        }
    }


}

class MyVisitor implements Runnable {

    private int visitorNum;

    public MyVisitor(int visitorNum) {
        this.visitorNum = visitorNum;
    }

    @Override
    public void run() {
        System.out.println("正在观看的是游客:" + visitorNum);
        Random random = new Random();
        try {
            Thread.currentThread().sleep(random.nextInt(3001) + 3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("游客" + visitorNum + "观看完毕");
        try {
            Thread.currentThread().sleep(random.nextInt(3001) + 6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}