package com.sun.stream;

import java.util.Random;

/**
 * create by qiulisun on 2019/3/3.<br>
 */
public class StreamRandomDemo {
    public static void main(String[] args){
        System.out.println("----- Java 7 -----");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }
        System.out.println("----- Java 8 -----");
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

}
