package com.sun.多线程.线程之间共享数据;

/**
 * 这里将要共享的数据（i）设置成为一个对象（MyData）,在该对象中操作i的方法加上sync关键字；
 * 线程初始化时利用构造函数把mydata对象传入，即可实现线程之间的数据共享（实际共享的是对象）
 * create by qiulisun on 2020/12/20.<br>
 *
 * @author 51050
 */
public class RunnableSharedDataDemo {
    public static void main(String[] args) {
        MyData data = new MyData();
        Runnable add = new AddRunnable(data);
        Runnable dec = new DecRunnable(data);


        for (int i = 0; i < 2; i++) {
            Thread threadAdd = new Thread(add);
            threadAdd.start();

            Thread threadDec = new Thread(dec);
            threadDec.start();
        }
    }
}
