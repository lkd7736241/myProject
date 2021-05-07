package com.sun.数据结构与算法.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 输入：9876673
 * 输出：37689
 * <p>
 * create by qiulisun on 2020/11/9.<br>
 */
public class 提取不重复的整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            String str = String.valueOf(anInt);

            StringBuffer buffer = new StringBuffer();
            Set<Character> set = new HashSet<>();
            char[] chars = str.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (set.contains(chars[i])) {
                    continue;
                } else {
                    set.add(chars[i]);
                    buffer.append(chars[i]);
                }
            }

            System.out.println(buffer.toString());
        }
    }
}
