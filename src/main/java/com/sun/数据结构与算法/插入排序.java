package com.sun.数据结构与算法;

/**
 * 1. 将一个元素插入到已经有序的数组中
 * 2. 从位置1开始（位置0看成是有序数组）
 * 3. 每次需要比较数组与之前的有序数组元素的大小（从末尾开始），找到一个地方将其插入
 * <p>
 * create by qiulisun on 2020/12/25.<br>
 *
 * @author 51050
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 2};
        int[] ints = insertionSort(array);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        int[] ints1 = insertionSort1(array);
        for (int i : ints1) {
            System.out.print(i + " ");
        }
    }

    public static int[] insertionSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    // 这里是错的
    public static int[] insertionSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                // 不能用j和i比较，要用j和j-1
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertionSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                int temp = array[j + 1];
                array[j + 1] = array[i];
                array[j] = temp;
            }
        }
        return array;
    }
}
