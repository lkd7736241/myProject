package com.sun.java基础;

import java.util.HashMap;

/**
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标
 * 你可以假设每种输入只会对应一个答案。但是，数组中的同一个元素不能使用两遍
 * create by qiulisun on 2021/12/1.<br>
 *
 * @author 51050
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoNumForOne(nums, target);
        for (int re : res) {
            System.out.println(re);
        }
    }

    /**
     * 双循环-暴力解决
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoNum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[j];
                if (num + num1 == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 利用hashmap（降低循环次数）
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoNumForHashMap(int[] nums, int target) {
        // 构建hashmap，key为数值，value为下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            // 数组中与nums[i]相加等于target，且其下标不等于i
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return null;
    }

    /**
     * 依然是利用hashmap，但又做了优化，只利用一次循环就完成
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoNumForOne(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
