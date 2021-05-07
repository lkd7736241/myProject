package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 求一个byte数字对应的二进制数字中1的最大连续数
 * 例如3的二进制为00000011，最大连续2个1
 * <p>
 * create by qiulisun on 2020/11/8.<br>
 */
public class 求最大连续bit数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();

            int input = anInt;
            int result = 0;
            StringBuffer buffer = new StringBuffer();
            while (input != 0) {
                int temp = input % 2;
                buffer.append(temp);
                input = input / 2;
            }
            String bufferString = buffer.toString();
            String[] split = bufferString.split("0+");
            for (String str : split) {
                result = Math.max(result, str.length());
            }
            System.out.println(result);
        }
    }
}
