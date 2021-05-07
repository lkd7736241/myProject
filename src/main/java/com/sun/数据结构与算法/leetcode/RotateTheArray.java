package com.sun.数据结构与算法.leetcode;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * create by qiulisun on 2019/3/10.<br>
 */
public class RotateTheArray {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7};
        int[] rotateTheArray = rotateTheArray(array, 3);
        for (int i : rotateTheArray) {
            System.out.println(i);
        }
    }

    public static int[] rotateTheArray(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = (i + k) % nums.length;
            result[num] = nums[i];
        }
        return result;
    }
}
