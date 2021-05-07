package com.sun.数据结构与算法.assignment;

/**
 * 数组对角线元素之和(这道题有问题)
 * create by qiulisun on 2019/2/8.<br>
 */
public class ArrayDiagonalValueSum {
    public static void main(String[] args){
        int[][] arrays = {
                {23, 106, 8, 234},
                {25, 9, 73, 19},
                {56, 25, 67, 137},
                {33, 22, 11, 44},
        };
        int result = doCalculate(arrays);
        System.out.println(result);
    }

    public static int doCalculate(int[][] arrays) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (i == j) {
                	sum = sum + arrays[i][j];
                }
            }
        }
        return sum;
    }
}
