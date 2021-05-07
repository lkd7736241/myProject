package com.sun.数据结构与算法;

/**
 * 在数组中选择一个元素（一般是位置在中间的节点）,比它小的放在左边，比它大的放在右边，不断重复这个过程
 * <p>
 * create by qiulisun on 2020/12/25.<br>
 *
 * @author 51050
 */
public class 快速排序 {
    public static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;

        // 支点
        int key = array[(left + right) / 2];

        while (i <= j) {
            while (key > array[i]) {
                i++;
            }

            while (key < array[j]) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(array, left, j);
        }

        if (i < right) {
            quickSort(array, i, right);
        }
    }
}
