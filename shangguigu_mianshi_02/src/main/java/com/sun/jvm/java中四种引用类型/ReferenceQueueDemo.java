package com.sun.jvm.java中四种引用类型;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 引用队列 对象被回收时将其放入引用队列
 * <p>
 * create by qiulisun on 2021/10/26.<br>
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, queue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

        System.out.println("=================");

        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());
    }
}
