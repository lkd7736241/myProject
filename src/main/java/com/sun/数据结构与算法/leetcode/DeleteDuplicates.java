package com.sun.数据结构与算法.leetcode;

/**
 * 从排序数组中删除重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * create by qiulisun on 2019/3/9.<br>
 */
public class DeleteDuplicates {
    public static void main(String[] args){
        int array[] = {1,1,2};
        int i = deleteDuplicates(array);
        System.out.println(i);
    }

    public static int deleteDuplicates(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            //这里不用array[i] != array[i-1],是为了避免
            if (array[i] != array[count]) {
                count++;
                array[count] = array[i];
            }
        }
        return ++count;
    }
}
