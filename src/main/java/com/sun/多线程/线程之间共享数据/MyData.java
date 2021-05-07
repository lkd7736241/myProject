package com.sun.多线程.线程之间共享数据;

/**
 * 执行线程的runnable作为一个内部类，要共享的数据作为这个类的成员变量--感觉这种方式很不会用到
 *
 * create by qiulisun on 2020/12/20.<br>
 * @author 51050
 */
public class MyData {
    private int j = 0;

    public synchronized void add() {
        j++;
        System.out.println("线程:" + Thread.currentThread().getName() + ", " + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println("线程:" + Thread.currentThread().getName() + ", " + j);
    }

    public int getData() {
        return j;
    }

}

class TestThread {
    public static void main(String[] args){
        final MyData data = new MyData();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.add();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.dec();
                }
            }).start();
        }
    }
}