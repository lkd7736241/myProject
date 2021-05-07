package com.sun.数据结构与算法.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * <p>
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * <p>
 * 如，输入： Type 输出： epTy
 * <p>
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * <p>
 * 如，输入： BabA 输出： aABb
 * <p>
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * <p>
 * <p>
 * 如，输入： By?e 输出： Be?y
 * <p>
 * create by qiulisun on 2020/11/10.<br>
 *
 * @author 51050
 */
public class 字符串排序Ⅱ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            StringBuilder builder = deal(line);
            System.out.println(builder.toString());
        }
    }

    private static StringBuilder deal(String line) {
        // 把字符过滤出来
        List<Character> list = new ArrayList<>();
        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                list.add(c);
            }
        }

        // 对字符进行排序
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });

        // 将非字符重新插入
        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                builder.append(list.get(j));
                j++;
            } else {
                builder.append(line.charAt(i));
            }
        }
        return builder;
    }

    private static boolean getBoolean(char c) {
        return String.valueOf(c).matches("[a-zA-Z]");
    }
}
