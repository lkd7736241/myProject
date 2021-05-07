package com.sun.数据结构与算法;

import java.util.stream.Stream;

/**
 * create by qiulisun on 2020/12/25.<br>
 *
 * @author 51050
 */
public class 递归_汉诺塔问题 {
    public static void main(String[] args) {
//        Predicate(? Super String> predicate = s -> s.startsWith("g");
//        Stream<String> stream1 = Stream.generate(() -> "growl! ");
//        Stream<String> stream2 = Stream.generate(() -> "growl! "); boolean b1 = stream1.anyMatch(predicate);
//        boolean b2 = stream2.allMatch(predicate); System.out.println(b1 + "" + b2);

        Stream<String> s = Stream.generate(() -> "meow");
        boolean match = s.allMatch(String::isEmpty);
        System.out.println(match);
    }
}
