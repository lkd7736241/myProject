package com.sun.数据结构与算法.assignment;

/**
 * 打印杨辉三角形
 * create by qiulisun on 2019/2/8.<br>
 */
public class YanghuiTriangle {
    public static void main(String[] args){
        int[][] result = doCalculate(3);
        for (int i = 0; i < result.length-1; i++) {
            for (int j = 0; j < result[i].length-1; j++) {
                if (i <= j) {
                	System.out.println(result[i][j]);
                }
            }
        }
    }

    public static int[][] doCalculate(int n) {
        //初始化行(n即为行数)
        int[][] array = new int[n][];
        //遍历行
        for (int i = 0; i < array.length; i++) {
            //初始化列(列数为i+1)
            array[i] = new int[i+1];
            //遍历列
            for (int j = 0; j < i + 1; j++) {
                //是第一列，第一行，行数等于列数，那么通通为1
                if (i == 0 || j == 0 || j == i) {
                    array[i][j] = 1;
                } else {

                    //当前值等于头上的值+头上左边的值
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }
        }
        //
        return array;
    }
}
