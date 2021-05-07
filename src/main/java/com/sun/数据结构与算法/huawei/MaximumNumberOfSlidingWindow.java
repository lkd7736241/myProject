package com.sun.数据结构与算法.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口
 * <p>
 * create by qiulisun on 2020/10/13.<br>
 * @author 51050
 */
public class MaximumNumberOfSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int temp = nums[i];
            for (int j = 0; j < k; j++) {
                if (temp < nums[i + j]) {
                    temp = nums[i + j];
                }
            }
            result.add(temp);
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
