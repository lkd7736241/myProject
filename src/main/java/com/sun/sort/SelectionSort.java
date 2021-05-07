package com.sun.sort;

/**
 * 选择排序(Selection sort)是一种简单直观的排序算法。
 * 它的工作原理是每一次从待排序的数据元素中选出最小(或最大)的一个元素，
 * 存放在序列的起始(末尾)位置，直到全部待排序的数据元素排完。
 * 选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。
 * create by qiulisun on 2018/12/16.<br>
 */
public class SelectionSort {

    public static void main(String[] args){

        int[] array = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        int[] selectionSort = doSelectionSort(array);
        for (int i = 0; i < selectionSort.length - 1; i++) {
            System.out.println(selectionSort[i]);
        }
    }

    public static int[] doSelectionSort(int[] array) {

        //记录当前趟数最大值的脚标
        int pos;

        //用于交换的变量
        int temp;

        //外层循环，用于控制趟数
        for (int i = 0; i < array.length - 1; i++) {
            //脚标清零
            pos = 0;
            //内层循环，控制当前趟遍历数组的个数，并找到最大值的脚标
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[pos]) {
                	pos = j;
                }
            }
            //将本趟遍历到的最大值放到数组末尾
            temp = array[pos];
            array[pos] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
