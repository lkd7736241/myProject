package com.sun.数据结构与算法.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * create by qiulisun on 2020/10/8.<br>
 */
public class BBB {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10*", "j");
        map.put("11*", "k");
        map.put("12*", "l");
        map.put("13*", "m");
        map.put("14*", "n");
        map.put("15*", "o");
        map.put("16*", "p");
        map.put("17*", "q");
        map.put("18*", "r");
        map.put("19*", "s");
        map.put("20*", "t");
        map.put("21*", "u");
        map.put("22*", "v");
        map.put("23*", "w");
        map.put("24*", "x");
        map.put("25*", "y");
        map.put("26*", "z");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split("");

            Map<Integer, Boolean> isUse = new HashMap<>();
            for (int i = 0; i < split.length; i++) {
                isUse.put(i, false);
            }

            Map<Integer, String> sort = new HashMap<>();
            for (int i = 0; i < split.length; i++) {
                String num = "";
                if ("*".equals(split[i])) {
                    num = split[i - 2] + split[i - 1] + split[i];
                    isUse.put(i - 2, true);
                    isUse.put(i - 1, true);
                    isUse.put(i, true);
                    String numTemp = num;
                    sort.put(i, numTemp);
                    num = "";
                }
            }

            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < split.length; i++) {
                if ("*".equals(split[i])) {
                    String s = sort.get(i);
                    String s1 = map.get(s);
                    buffer.append(s1);
                } else {
                    if (!isUse.get(i)) {
                        String s2 = map.get(split[i]);
                        buffer.append(s2);
                    }
                }

            }
            System.out.println(buffer.toString());
        }
    }
}
