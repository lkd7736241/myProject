package com.sun.sort;

/**
 * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
 * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，
 * 时间复杂度为O(n^2)。是稳定的排序方法。
 * create by qiulisun on 2018/12/16.<br>
 */
public class InsertionSort {
    public static void main(String[] args){
        int array[] = {99, 2, 3, 1, 22, 88, 7, 77, 54};
        int[] insertionSort = doInsertionSort(array);
        for (int i = 0; i < insertionSort.length; i++) {
            System.out.println(insertionSort[i]);
        }
    }

    public static int[] doInsertionSort(int[] array) {
        //临时变量
        int temp;
        //外层循环，用于控制遍历的趟数(这里从1开始遍历，因为将array[0]看成了一个有序的数组，后面的数据都是插入这个数组中)
        for (int i = 1; i < array.length; i++) {

            temp = array[i];

            //临时变量比要比较的有序数组最后一个要小，所以要向前寻找要插入的位置
            while ((i >= 1) && (array[i-1] > temp)){
                //将有序数组的元素向后移
                array[i] = array[i - 1];
                i--;
            }
            array[i] = temp;
        }
        return array;
    }
}
