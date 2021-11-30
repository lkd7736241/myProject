package com.sun.jvm.oom_内存溢出;

import java.util.Random;

/**
 * java.lang.OutOfMemoryError:Java heap space
 *
 * create by qiulisun on 2021/10/26.<br>
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "seu";

        while (true) {
            str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
            str.intern();
        }
    }
}
