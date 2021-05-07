package com.sun.数据结构与算法.leetcode;

import java.util.Scanner;

/**
 * 整数翻转
 * create by qiulisun on 2020/1/31.<br>
 */
public class IntegerFlip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        int reverse = reverse(integer);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x = x / 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int) rs;
    }
}
