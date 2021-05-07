package com.sun.多线程.线程之间共享数据;

/**
 * create by qiulisun on 2020/12/20.<br>
 * @author 51050
 */
public class DecRunnable implements Runnable {
    private MyData data;

    public DecRunnable(MyData data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.dec();
    }
}
