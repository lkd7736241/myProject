package com.sun.数据结构与算法;

/**
 * 希尔排序是根据插入排序改进的
 * create by qiulisun on 2021/4/1.<br>
 *
 * @author 51050
 */
public class 希尔排序 {
    public static int[] shellSort(int[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (array[j] < array[j - gap]) {
                        int temp = array[j];
                        array[j] = array[j - gap];
                        array[j - gap] = temp;
                    }
                }
            }
        }

        return array;
    }
}
