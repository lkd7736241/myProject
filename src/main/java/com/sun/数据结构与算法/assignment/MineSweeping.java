package com.sun.数据结构与算法.assignment;

import java.util.Random;

/**
 * 生成一个扫雷的二维数组棋盘
 * 输入：长度，宽度，雷的个数
 * 输出：一个二维数组，其中将雷随机散布到整个棋盘中，雷用-1表示，不是雷地方用数字表示周围有几个雷。
 * 将生成的棋盘按长宽格式打印出来
 * create by qiulisun on 2019/1/2.<br>
 */
public class MineSweeping {

    public static void main(String[] args){

        int[][] mineSweeping = doMineSweeping(8, 8, 24);
        for (int i = 0; i < mineSweeping.length; i++) {
            for (int j = 0; j < mineSweeping[0].length; j++) {
                System.out.println(" " + mineSweeping[i][j] + " ");
            }
        }
    }

    public static int[][] doMineSweeping(int length, int width, int mineNum) {

        int[][] result = new int[length][width];
        Random random = new Random();
        int count = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < width - 1; j++)
                if (random.nextBoolean()) {
                    result[i][j] = -1;
                    count++;
                    if (count == mineNum) {
                        for (int k = i + 1; k < length - 1; k++) {
                            for (int l = j + 1; l < width - 1; l++) {
                                result[k][l] = 0;
                            }
                        }
                        break;
                    }
                } else {
                    result[i][j] = 0;
                }
        }

//        for (int i = 0; i < length - 1; i++) {
//            for (int j = 0; j < width - 1; j++) {
//
//            }
//        }
        return result;
    }
}
