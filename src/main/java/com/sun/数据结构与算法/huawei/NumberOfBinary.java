package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 二进制数中1的个数
 * create by qiulisun on 2020/10/6.<br>
 * @author 51050
 */
public class NumberOfBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            System.out.println(findNumberOf1(anInt));
        }
    }

    private static int findNumberOf1(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                count++;
            }
            num = num / 2;
        }
        return count;
    }
}
