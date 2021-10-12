package com.sun.第一季.迭代与递归;

/**
 * 题目：可以一次上一级台阶，也可以一次上两级台阶；现在有n级台阶，求一共有几种上台阶的方法
 * create by qiulisun on 2021/10/7.<br>
 */
public class Recursion {
    public static int f(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n - 2) + f(n - 1);
    }
}
