package com.sun.数据结构与算法.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入：输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出：数据输出n行，输出结果为按照字典序排列的字符串。
 * <p>
 * create by qiulisun on 2020/11/9.<br>
 */
public class 字符串排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < anInt; i++) {
                String next = scanner.next();
                list.add(next);
            }

            List<String> sorted = list.stream().sorted().collect(Collectors.toList());
            for (String str : sorted) {
                System.out.println(str);
            }
        }
    }
}
