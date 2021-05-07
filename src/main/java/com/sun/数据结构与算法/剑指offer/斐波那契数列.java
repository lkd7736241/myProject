package com.sun.数据结构与算法.剑指offer;

import java.util.Scanner;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * <p>
 * create by qiulisun on 2020/11/18.<br>
 *
 * @author 51050
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            int fibonacci = Fibonacci(anInt);
            System.out.println(fibonacci);
        }
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
