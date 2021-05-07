package com.sun.数据结构与算法.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个整数数组，里面有且只有一堆散乱的0和1，写一个方法，使所有的0都移到数组左边，所有的1移到数组右边
 * 要求：时间复杂度o(n)
 * 例：1 0 0 0 1 0 1 0 1 1 => 0 0 0 0 0 1 1 1 1
 * create by qiulisun on 2018/12/27.<br>
 */
public class ZeroAndOne {

    public static void main(String[] args){

        Integer[] temp = {1, 0, 0, 0, 1, 0, 1, 0, 1, 1};
        Integer[] result = doZeroAndOne(temp);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static Integer[] doZeroAndOne(Integer[] array) {

        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
            	zero.add(0);
            } else if (array[i] == 1) {
            	one.add(1);
            }
        }

        zero.addAll(one);
        Integer[] result = zero.toArray(new Integer[zero.size()]);
        return result;
    }
}
