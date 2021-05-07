package com.sun.数据结构与算法.剑指offer;

/**
 * create by qiulisun on 2020/11/20.<br>
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        // 如果底数是0则返回0
        if (base == 0.0) {
            return 0.0;
        }
        // 将返回值设置为1（如果指数是0，则默认的返回值是1）
        double res = 1.0;
        // 取指数的绝对值
        int absEx = exponent > 0 ? exponent : -exponent;
        // 累乘计算
        for (int i = 0; i < absEx; i++) {
            res *= base;
        }
        // 根据指数正负，返回累乘结果或者累乘结果分之一
        return exponent > 0 ? res : 1 / res;
    }
}
