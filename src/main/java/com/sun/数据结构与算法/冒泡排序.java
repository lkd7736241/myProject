package com.sun.数据结构与算法;

/**
 * 1. 对数组每两个数挨个比较，若前者大于后者则则将其交换
 * 2. 经过一趟排序将最大的元素放在了数组末尾
 * 3. 经过n-1趟排序将整个数组排序好（外层循环控制）
 * 4. 每次排序需将上一趟排序选出的最大元素剔除出排序序列（需要排序的元素为内层循环控制）
 * <p>
 * create by qiulisun on 2020/12/24.<br>
 *
 * @author 51050
 */
public class 冒泡排序 {
    public static int[] bubbleSort(int[] array) {
        int temp;
        int isChange;
        for (int i = 0; i < array.length - 1; i++) {
            // 每趟排序开始，将是否发生元素交换的标致设置为0
            isChange = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    // 发生元素交换，将标致设置为1
                    isChange = 1;
                }
            }
            if (isChange == 0) {
                break;
            }
        }
        return array;
    }

    public static int[] bubbleSort1(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2};
        int[] ints = bubbleSort1(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
