package com.sun.数据结构与算法.leetcode;

import java.util.Scanner;

/**
 * create by qiulisun on 2020/10/8.<br>
 */
public class AAA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nums = scanner.nextLine();
            String sumStr = scanner.nextLine();
            String[] split = nums.split(",");
            Integer sum = Integer.valueOf(sumStr);

            int result = 0;
            for (int i = 0; i < split.length; i++) {
                int temp = 0;
                int length = 0;
                for (int j = i; j < split.length; j++) {
                    temp += Integer.valueOf(split[j]);
                    length++;
                    if (temp == sum) {
                        result = Math.max(length, result);
                    }
                }
            }
            if (result > 0) {
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }
    }
}


