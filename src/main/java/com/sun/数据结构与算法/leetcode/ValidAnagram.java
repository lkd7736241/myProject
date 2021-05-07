package com.sun.数据结构与算法.leetcode;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 字母异位词是指由相同的字母按照不同的顺序组成的单词
 * create by qiulisun on 2020/2/1.<br>
 */
public class ValidAnagram {
    public static void main(String[] args){

    }

    public static boolean isAnagram(String s, String t) {
        // 1. 字符串长度不一致
        if (s.length() != t.length()) {
        	return false;
        }
        // 2. 对字符串排序
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        // 3. 判断字符是否一致
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
            	return false;
            }
        }
        return true;
    }
}
