package com.sun.数据结构与算法.assignment;

/**
 * 1-n阶乘的和
 * create by qiulisun on 2019/2/8.<br>
 */
public class Factorial {
    public static void main(String[] args){

        int factorial = doFactorial(3);
        System.out.println(factorial);
    }

    public static int doFactorial(int n) {
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            sum = sum + factorial;
        }
        return sum;
    }
}
