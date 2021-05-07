package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 最长公共子串的长度
 * <p>
 * create by qiulisun on 2020/11/7.<br>
 *
 * @author 51050
 */
public class 最长公共子串的长度 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String t = in.nextLine();
            int result = getCommonStrLength(s, t);
            System.out.println(result);
        }
    }

    private static int getCommonStrLength(String s, String t) {
        int result = 0;
        for (int j = 0; j < t.length(); j++) {
            for (int i = 0, val = 0; i < s.length() && i + j < t.length(); i++) {
                if (t.charAt(i + j) == s.charAt(i)) {
                    val++;
                    result = Math.max(result, val);
                } else {
                    val = 0;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0, val = 0; j < t.length() && i + j < s.length(); j++) {
                if (s.charAt(i + j) == t.charAt(j)) {
                    val++;
                    result = Math.max(result, val);
                } else {
                    val = 0;
                }
            }
        }
        return result;
    }

    /**
     * 使用动态规划寻找最长公共子串
     *
     * @param s
     * @param t
     * @return
     */
    private static int getCommonStrLengthByDynamicProgramming(String s, String t) {
        int result = 0;
        int length1 = s.length();
        int length2 = t.length();

        int dp[][] = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
