package com.sun.数据结构与算法.剑指offer;

import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 输入："ab"
 * 输出：["ab","ba"]
 *
 * 解题思路：使用动态规划的方式，先取某个字符，将剩余字符串递归，再拼接
 * <p>
 * create by qiulisun on 2021/3/24.<br>
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        Permutation("a");
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str.length() == 0) {
            return null;
        } else if (str.length() == 1) {
            arrayList.add(str);
            return arrayList;
        }
        for (int i = 0; i < str.length(); i++) {
            String str1 = str.substring(0, i) + str.substring(i + 1);
            String str2 = str.substring(i, i + 1);

            ArrayList<String> permutation = Permutation(str1);
            for (String str3 : permutation) {
                String str4 = str2 + str3;
                if (!arrayList.contains(str4)) {
                    arrayList.add(str4);
                }
            }
        }
        return arrayList;
    }
}
