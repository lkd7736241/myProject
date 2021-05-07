package com.sun.数据结构与算法.leetcode;

import java.util.Scanner;

/**
 * 字符逆序
 * <p>
 * create by qiulisun on 2020/11/6.<br>
 *
 * @author 51050
 */
public class CharactersInReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            StringBuffer buffer = new StringBuffer();
            for (int i = chars.length - 1; i >= 0; i--) {
                buffer.append(chars[i]);
            }
            System.out.println(buffer);
        }
    }
}
