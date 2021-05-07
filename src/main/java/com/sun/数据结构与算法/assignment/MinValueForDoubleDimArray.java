package com.sun.数据结构与算法.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找二维数组中每列的最小值
 * create by qiulisun on 2019/2/8.<br>
 */
public class MinValueForDoubleDimArray {
    public static void main(String[] args){
        int[][] arrays = {
                {23, 106, 8, 234},
                {25, 9, 73, 19},
                {56, 25, 67, 137}
        };
        List<Integer> result = doFind(arrays);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    
    public static List<Integer> doFind(int[][] douDimArray) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < douDimArray.length; i++) {
            int temp = douDimArray[i][0];
            for (int j = 0; j < douDimArray[i].length; j++) {
                if (douDimArray[i][j] < temp) {
                	temp = douDimArray[i][j];
                }
            }
            result.add(temp);
        }
        return result;
    }
}
