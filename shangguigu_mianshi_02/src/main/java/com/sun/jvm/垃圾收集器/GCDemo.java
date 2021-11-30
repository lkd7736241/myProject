package com.sun.jvm.垃圾收集器;

import java.util.Random;

/**
 * create by qiulisun on 2021/10/29.<br>
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("GCDemo...");
        try {
            String str = "bjtu";
            while (true) {
                str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
