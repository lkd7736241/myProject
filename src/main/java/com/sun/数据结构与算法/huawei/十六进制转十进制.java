package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * create by qiulisun on 2020/11/8.<br>
 *
 * @author 51050
 */
public class 十六进制转十进制 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String substring = line.substring(2);

            int result = 0;
            int multiplier = 1;
            for (int i = substring.length() - 1; i >= 0; i--) {
                char c = substring.charAt(i);
                if (c >= '0' && c <= '9') {
                    result += (c - '0') * multiplier;
                } else if (c >= 'A' && c <= 'F') {
                    result += (c - 'A' + 10) * multiplier;
                }
                multiplier *= 16;
            }
            System.out.println(result);
        }
    }

    private static void methodOne(String line) {
        Integer value = Integer.valueOf(line.substring(2), 16);
        System.out.println(value.toString());
    }
}
