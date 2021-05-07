package com.sun.数据结构与算法.剑指offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * create by qiulisun on 2020/11/17.<br>
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        int i = minNumberInRotateArray(array);
        System.out.println(i);
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if (temp > array[i]) {
                temp = array[i];
            }
        }
        return temp;
    }

    /**
     * 使用二分查找
     * 分析：二分查找变种，没有具体的值用来比较。
     * 那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
     * <p>
     * 处于递增：low上移
     * <p>
     * 处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）
     * <p>
     * 其余情况：low++缩小范围
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            if (array[first] < array[last]) {
                return array[first];
            }

            int mid = first + (last - first) / 2;
            if (array[mid] > array[last]) {
                first = mid + 1;
            } else if (array[mid] < array[last]) {
                last = mid;
            } else {
                last = last - 1;
            }
        }
        return array[first];
    }
}
