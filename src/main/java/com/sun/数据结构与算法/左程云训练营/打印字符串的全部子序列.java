package com.sun.数据结构与算法.左程云训练营;

import java.util.List;

/**
 * create by qiulisun on 2021/4/6.<br>
 *
 * @author 51050
 */
public class 打印字符串的全部子序列 {
    public static void printAll(char[] chars, int index, List<String> ans, String path) {
        if (index == chars.length) {
            ans.add(path);
            return;
        }
        String no = path;
        printAll(chars, index + 1, ans, no);
        String yes = path + String.valueOf(chars[index]);
        printAll(chars, index + 1, ans, yes);
    }
}
