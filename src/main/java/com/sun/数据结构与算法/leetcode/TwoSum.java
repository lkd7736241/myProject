package com.sun.数据结构与算法.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * create by qiulisun on 2019/3/17.<br>
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] param = {3, 2, 4};
        int target = 6;
        int[] sum = twoSum(param, target);
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }

    /**
     * 自己的实现（暴力实现）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 答案
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumTheAnswer(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
