package com.sun.jvm.java中四种引用类型;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * create by qiulisun on 2021/10/26.<br>
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, queue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

        System.out.println("================================");

        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
    }
}
