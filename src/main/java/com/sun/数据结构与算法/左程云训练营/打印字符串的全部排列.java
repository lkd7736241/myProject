package com.sun.数据结构与算法.左程云训练营;

import java.util.ArrayList;

/**
 * create by qiulisun on 2021/4/7.<br>
 *
 * @author 51050
 */
public class 打印字符串的全部排列 {
    /**
     * @param chars
     * @param i
     * @param ans
     */
    public static void process(char[] chars, int i, ArrayList<String> ans) {
        if (i == chars.length) {
            ans.add(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i+1, ans);
            swap(chars, i, j);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
