package com.sun.数据结构与算法;

/**
 * 1）整体就是一个简单递归，左边排好序、右边排好序、让其整体有序
 * 2）让其整体有序的过程里用了排外序方法
 * 3）利用master公式来求解时间复杂度
 * 4）归并排序的实质
 * 时间复杂度O(N*logN)，额外空间复杂度O(N)
 * create by qiulisun on 2021/4/8.<br>
 *
 * @author 51050
 */
public class 归并排序 {
    public static void merge(int[] array, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2];
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= right) {
            help[i++] = array[p2++];
        }
        for (i = 0; i < help.length; i++) {
            array[right + i] = help[i];
        }
    }
}
