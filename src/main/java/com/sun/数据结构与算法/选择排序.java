package com.sun.数据结构与算法;

/**
 * 1. 每次找出数组中最大的元素，与最后一个元素交换
 * <p>
 * create by qiulisun on 2020/12/24.<br>
 *
 * @author 51050
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 7, 9};
        int[] ints = selectionSort1(array);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }

    public static int[] selectionSort(int[] array) {
        // 用于交换的变量
        int temp;
        // 当前最大值得脚标
        int position = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // 排序开始，最大值脚标默认为0
            position = 0;
            for (int j = 0; j <= array.length - 1 - i; j++) {
                if (array[j] > array[position]) {
                    position = j;
                }
            }

            temp = array[position];
            array[position] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static int[] selectionSort1(int[] array) {
        // 对剩余元素继续找最小
        for (int i = 0; i < array.length; i++) {
            // 找到最小值的脚标
            int minPos = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            // 将最小值移动到最前方
            int temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;
            System.out.println(array[i]);
        }

        return array;
    }
}
