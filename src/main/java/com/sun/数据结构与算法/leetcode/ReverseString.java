package com.sun.数据结构与算法.leetcode;

/**
 * 反转字符串
 * create by qiulisun on 2019/5/4.<br>
 * @author 51050
 */
public class ReverseString {
    public static void main(String[] args){
        String str = "huochepiao";
        String result = doReverseString(str);
        System.out.println(result);
    }

    private static String doReverseString(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
