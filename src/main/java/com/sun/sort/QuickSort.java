package com.sun.sort;

/**
 * 快速排序由C. A. R. Hoare在1962年提出。
 * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 在数组中找一个支点(任意),经过一趟排序后，支点左边的数都要比支点小，支点右边的数都要比支点大！
 * create by qiulisun on 2018/12/16.<br>
 */
public class QuickSort {
    public static void main(String[] args){
        int[] array = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
        doQuickSort(array, 0, 9);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] doQuickSort(int[] array, int left, int right) {

        int i = left;
        int j = right;

        //支点
        int piovt = array[(left+right)/2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j){
            //寻找直到比支点大的数
            while (piovt > array[i])
                i++;
            //寻找直到比支点小的数
            while (piovt < array[j])
                j--;

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。

        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (left < j) {
            doQuickSort(array, left, j);
        }
        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (right > i) {
            doQuickSort(array, i, right);
        }
        return array;
    }
}
