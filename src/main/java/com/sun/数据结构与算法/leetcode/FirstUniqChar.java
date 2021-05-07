package com.sun.数据结构与算法.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * create by qiulisun on 2019/5/12.<br>
 *
 * @author 51050
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String str = "cc";
        int i = doFirstUniqChar(str);
        System.out.println(i);
    }

    public static int doFirstUniqChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, i);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer integer = map.get(c);
            if (integer == i) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s) {
        // 分成两种情况：
        // 第一种为字符串长度小于26的，遍历字符串
        if (s.length() <= 26) {
            //存储各字符出现次数
            int[] charNum = new int[26];
            char[] chars = s.toCharArray();
            int length = chars.length;
            //第一次遍历,记录各个字符出现次数
            for (int i = 0; i < length; i++) {
                charNum[chars[i] - 'a']++;
            }
            //第二次遍历，按顺序，如果次数为1，返回下标
            for (int i = 0; i < length; i++) {
                if (charNum[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }

        // 第二种字符串长度大于26，遍历26个字母
        // 反过来，只有26个字符
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }
}
