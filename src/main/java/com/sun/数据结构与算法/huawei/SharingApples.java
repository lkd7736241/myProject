package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 分苹果
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * （用K表示）5，1，1和1，5，1 是同一种分法。
 * create by qiulisun on 2020/10/6.<br>
 * @author 51050
 */
public class SharingApples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = getCount(scanner.nextInt(), scanner.nextInt());
            System.out.println(count);
        }
        scanner.close();
    }

    private static int getCount(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 1 || n == 1 || m == 0) {
            return 1;
        }
        // 递归
        return getCount(m - n, n) + getCount(m, n - 1);
    }
}
