package com.sun.数据结构与算法.剑指offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 输入：7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 输出：true
 * <p>
 * create by qiulisun on 2021/3/16.<br>
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean find = Find(7, array);
        System.out.println(find);
    }

    public static boolean Find(int target, int[][] array) {
        int colMin = 0, colMax = array.length - 1;
        while (colMin < colMax) {
            int colMid = colMin + (colMax - colMin) / 2;
            int[] colTemp = array[colMid];
            if (colTemp[0] == target) {
                return true;
            } else if (colTemp[colTemp.length - 1] == target) {
                return true;
            } else if (colTemp[0] > target) {
                colMax = colMid - 1;
                continue;
            } else if (colTemp[colTemp.length - 1] < target) {
                colMin = colMid + 1;
                continue;
            } else {
                int lineMin = 0, lineMax = colTemp.length - 1;
                while (lineMin < lineMax) {
                    int lineMid = lineMin + (lineMax - lineMin) / 2;
                    if (colTemp[lineMid] == target) {
                        return true;
                    } else if (colTemp[lineMid] > target) {
                        lineMax = lineMid - 1;
                    } else if (colTemp[lineMid] < target) {
                        lineMin = lineMid + 1;
                    }
                }

            }
        }

        return false;
    }
}
