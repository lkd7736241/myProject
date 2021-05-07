package com.sun.数据结构与算法.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
 * 不在范围内的不作统计; 多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * <p>
 * create by qiulisun on 2020/11/9.<br>
 */
public class 字符个数统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            char[] chars = next.toCharArray();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i <= chars.length - 1; i++) {
                set.add(chars[i]);
            }
            System.out.println(set.size());
        }
    }
}
