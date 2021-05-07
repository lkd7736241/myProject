package com.sun.数据结构与算法.左程云训练营;

/**
 * 给定一个字符串str和长度leftSize,请把str左侧leftSize的部分和右部分做整体交换。
 * 要求额外空间复杂度O(1)
 * <p>
 * 输入：[a,b,c,d,e,f], 4
 * 输出：[e,f,a,b,c,d]
 * create by qiulisun on 2021/4/6.<br>
 *
 * @author 51050
 */
public class 字符串整体交换 {

    public static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 1. 将左边逆序；2. 将右边逆序 3. 再整体逆序
     *
     * @param array
     * @param leftSize
     * @return
     */
    public int[] swapLeftSize(int[] array, int leftSize) {
        reverse(array, 0, leftSize - 1);
        reverse(array, leftSize, array.length - 1);
        reverse(array, 0, array.length - 1);
        return array;
    }
}
