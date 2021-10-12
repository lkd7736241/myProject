package com.sun.第一季.迭代与递归;

/**
 * 迭代实现
 * create by qiulisun on 2021/10/7.<br>
 */
public class Iteration {
    public static int loop(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int one = 2; // 最后走一步的走法
        int two = 1; // 最后走两步的走法
        int sum = 0; // 总共的走法

        for (int i = 3; i <= n; i++) {
            // f(i) = f(i-1) + f(i-2)
            sum = one + two;
            // 对于i+1 f((i+1)-2) = f(i-1)
            two = one;
            // 对于i+1 f((i+1)-1) = f(i)
            one = sum;
        }
        return sum;
    }
}
