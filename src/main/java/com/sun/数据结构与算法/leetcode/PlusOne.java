package com.sun.数据结构与算法.leetcode;

import java.util.Scanner;

/**
 * 加一<br>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。<br>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。<br>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。<br>
 * create by qiulisun on 2019/3/17.<br>
 */
public class PlusOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split(",");
        int[] digits = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            digits[i] = Integer.valueOf(split[i]);
        }
        int[] ints = plusOne(digits);
        System.out.println(ints);
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = 0; i < length - 1; i++) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
            	return digits;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}
