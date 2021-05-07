package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 统计大写字母的个数
 * <p>
 * create by qiulisun on 2020/11/8.<br>
 *
 * @author 51050
 */
public class StatisticsOfTheNumberOfCapitalLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int num = 0;
            for (char aChar : chars) {
                if (aChar >= 'A' && aChar <= 'Z') {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
