package com.sun.数据结构与算法.剑指offer;

/**
 * 统计一个数字在升序数组中出现的次数
 * <p>
 * create by qiulisun on 2021/3/15.<br>
 */
public class 数字在升序数组中出现的次数 {
    /**
     * 暴力查找
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                res++;
            }
        }
        return res;
    }

    /**
     * 利用二分查找
     * 显然方法一没有把数组有序的条件利用上，也很显然是利用二分查找。因为有序，所以目标值target如果有多个，肯定是连在一起。又已知我们可以在有序数组中查找任意一个值，因此我们可以先查找目标范围的下界和上界。
     * 下界定义为：如果存在目标值，则指向第一个目标值，否则，如果不存在， 则指向大于目标值的第一个值。
     * 上界定义为：不管目标值存在与否，都指向大于目标值的第一个值。
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK1(int[] array, int k) {
        int lbound = 0, rboudn = 0;
        int left = 0, right = array.length;
        // 寻找上界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        lbound = left;

        // 寻找下界
        left = 0;
        right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        rboudn = left;

        return rboudn - lbound;
    }
}
