package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * create by qiulisun on 2021/1/8.<br>
 *
 * @author 51050
 */
public class 最长公共子序列的长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            int subsequence = getLongestCommonSubsequence(s1, s2);
            System.out.println(subsequence);
        }
    }

    /**
     * 使用动态规划找出字符串最长公共子序列的长度
     * @param s
     * @param t
     * @return
     */
    private static int getLongestCommonSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
