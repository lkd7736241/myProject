package com.sun.数据结构与算法.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * create by qiulisun on 2021/1/12.<br>
 *
 * @author 51050
 */
public class DNA序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String source = scanner.next();
            int length = scanner.nextInt();


            String target = getTarget(source, length);
            System.out.println(target);
        }
    }

    private static String getTarget(String source, int length) {
        char[] chars = source.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int num = 0;
            for (int j = i; j < (i + length); j++) {
                if (j < chars.length && (chars[j] == 'G' || chars[j] == 'C')) {
                    num++;
                }
            }
            map.put(i, num);
        }

        int max = 0;
        int target = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                target = entry.getKey();
            }
        }

        return source.substring(target, target + length);
    }
}
