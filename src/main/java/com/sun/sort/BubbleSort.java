package com.sun.sort;

/**
 * 冒泡排序（Bubble Sort，台湾译为：泡沫排序或气泡排序）是一种简单的排序算法。
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名。
 * create by qiulisun on 2018/12/16.<br>
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] array = {2, 5, 1, 3, 4};
        int[] bubbleSort = doBubbleSort(array);
        for (int i = 0; i < bubbleSort.length; i++) {
            System.out.println(bubbleSort[i]);
        }
    }

    public static int[] doBubbleSort(int[] array) {

        //装载临时变量
        int temp ;
        //记录是否发生了交换，0表示没有发生交换，1表示发生了交换
        int isChange ;
        //外层循环控制遍历次数
        for (int i = 0; i < array.length - 1; i++) {
            isChange = 0;
            //内层循环控制当前遍历需要比较的次数
            for (int j = 0; j < array.length - i - 1; j++) {
                //如果前一位数比后一位数大就将他们交换
                if (array[j] > array[j+1]) {
                	temp = array[j];
                	array[j] = array[j+1];
                	array[j+1] = temp;
                    //发生了交换
                	isChange = 1;
                }
            }
            //如果没有发生交换，说明排序已经完成，不需要再执行下去
            if (isChange == 0) {
                break;
            }
        }

        return array;
    }
}
