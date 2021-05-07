package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * create by qiulisun on 2021/1/8.<br>
 *
 * @author 51050
 */
public class 最长公共子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();

            String substring = getLongestCommonSubstring(s1, s2);
            System.out.println(substring);
        }
    }

    private static String getLongestCommonSubstring(String s, String t) {
        int result = 0;
        int length1 = s.length();
        int length2 = t.length();

        int dp[][] = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = dp[i][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int num = 0;
        int max = 0;
        if (s.length() < t.length()) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        num = i;
                    }
                }
            }
        } else {
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (dp[j][i] > max) {
                        max = dp[j][i];
                        num = j;
                    }
                }
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = num - max; i < num; i++) {
            buffer.append(sCharArray[i]);
        }
        return buffer.toString();
    }
}
