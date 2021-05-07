package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 完全数
 * create by qiulisun on 2020/10/3.<br>
 * @author 51050
 */
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            int count = 0;
            for (int i = 2; i < anInt; i++) {
                if (checkPerfectNumber(i)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum + 1 == num) {
            return true;
        } else {
            return false;
        }
    }
}
