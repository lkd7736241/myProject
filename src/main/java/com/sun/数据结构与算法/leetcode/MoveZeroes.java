package com.sun.数据结构与算法.leetcode;

/**
 *  移动零<br>
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。<br>
 *  说明:<br>
 *  1.必须在原数组上操作，不能拷贝额外的数组。<br>
 *  2.尽量减少操作次数。<br>
 * create by qiulisun on 2019/3/17.<br>
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if (nums[i] == 0) {
                for (int k = i; k < j; k++) {
                    nums[k] = nums[k+1];
                }
                nums[j] = 0;
                j--;
            } else {
                i++;
            }
        }
    }
}
