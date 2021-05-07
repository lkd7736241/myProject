package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * <p>
 * 2 5 9 14
 * <p>
 * 4 8 13
 * <p>
 * 7 12
 * <p>
 * 11
 * <p>
 * create by qiulisun on 2020/11/29.<br>
 */
public class 蛇形矩阵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int count = 1 + i;
                StringBuffer buffer = new StringBuffer().append(count).append(" ");
                for (int j = 0; j <= num - 2; j++) {
                    count += (2 + j);
                    buffer.append(count).append(" ");
                }
                String res = buffer.toString();
                System.out.println(res);
            }
        }
    }
}
