package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 数字颠倒
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * <p>
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * create by qiulisun on 2020/10/2.<br>
 * @author 51050
 */
public class DigitalUpsideDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int down = getDown(line);
        System.out.println(down);
    }

    private static int getDown(int i) {
        long temp = 0;
        while (i != 0) {
            temp = temp * 10 + i % 10;
            i = i / 10;
        }
        return temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE ? 0 : (int) temp;
    }
}
