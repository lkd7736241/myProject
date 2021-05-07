package com.sun.数据结构与算法.剑指offer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 输入：
 * [1,-2,3,10,-4,7,2,-5]
 * 输出：
 * 18
 * 说明：输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 * create by qiulisun on 2021/3/22.<br>
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int sum = FindGreatestSumOfSubArray(array);
        System.out.println(sum);
    }

    /**
     * 暴力法解决
     *
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 典型的动态规划。dp[n]代表以当前元素为截止点的连续子序列的最大和，
     * 如果dp[n-1]>0，dp[n]=dp[n]+dp[n-1]，因为当前数字加上一个正数一定会变大；
     * 如果dp[n-1]<0，dp[n]不变，因为当前数字加上一个负数一定会变小。
     * 使用一个变量max记录最大的dp值返回即可。
     *
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray1(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i - 1] >= 0) {
                array[i] += array[i - 1];
            } else {
                continue;
            }
            max = Math.max(max, array[i]);
        }

        return max;
    }
}
