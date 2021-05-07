package com.sun.数据结构与算法.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * 求"1！+4！(2的平方)+9！(3的平方)+...+n的值
 * create by qiulisun on 2019/2/8.<br>
 */
public class SquareFactorial {

    public static void main(String[] args){
        int result = doCalculate(3);
        System.out.println(result);
    }

    public static int doCalculate(int n) {
        List<Integer> squares = new ArrayList<>();
        int sum = 0;
        int square = 0;
        //求需要计算阶乘的数组
        for (int i = 1; i <= n; i++) {
            square = i*i;
            squares.add(square);
        }
        if (squares.size() > 0) {
            for (int i = 0; i < squares.size(); i++) {
                sum = sum + doFactorial(squares.get(i));
            }
        }
        return sum;
    }

    /**
     * 求n的阶乘
     * @return
     */
    public static int doFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
