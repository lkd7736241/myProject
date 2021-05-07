package com.sun.数据结构与算法.leetcode;

import java.util.Scanner;

/**
 * 二进制转换
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * <p>
 * create by qiulisun on 2020/10/2.<br>
 * @author 51050
 */
public class BinaryConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        int count = 0;

        while (anInt >= 1) {
            if (anInt % 2 == 1) {
                count++;
            }
            anInt = anInt / 2;
        }
        System.out.println(count);
    }
}
