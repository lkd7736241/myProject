package com.sun.数据结构与算法.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字<br>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素.<br>
 * create by qiulisun on 2019/3/4.<br>
 */
public class SingleNumber {

    public static int doSingleNumber(int[] nums) {
        int result = -1;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
            	map.put(num, true);
            } else {
                map.put(num, false);
            }
        }
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
            	result = entry.getKey();
            }
        }
        return result;
    }
}
