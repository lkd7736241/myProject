package com.sun.数据结构与算法.剑指offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * f(n) = f(n-1)+f(n-2)
 * <p>
 * create by qiulisun on 2020/11/19.<br>
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int res = JumpFloor(target - 1) + JumpFloor(target - 2);
        return res;
    }
}
