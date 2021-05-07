package com.sun.数据结构与算法.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复<br>
 * 给定一个整数数组，判断是否存在重复元素。<br>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。<br>
 * create by qiulisun on 2019/3/16.<br>
 */
public class ContainsDuplicate {
    public static boolean doContainsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, false);
            }
        }
        return false;
    }
}
