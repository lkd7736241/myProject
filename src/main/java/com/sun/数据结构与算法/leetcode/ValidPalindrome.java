package com.sun.数据结构与算法.leetcode;

/**
 * 验证回文字符串
 * <p>
 * create by qiulisun on 2020/2/2.<br>
 */
public class ValidPalindrome {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            boolean existed = (temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z') || (temp >= '0' && temp <= '9');
            if (existed) {
                if ((temp >= 'A' && temp <= 'Z')) {
                    temp = (char) (temp - 'A' + 'a');
                }
                builder.append(temp);
            }
        }
        String reverse = builder.toString();
        if (builder.reverse().toString().equals(reverse)) {
        	return true;
        } else {
            return false;
        }
    }
}
