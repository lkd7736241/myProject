package com.sun.数据结构与算法.assignment;

import java.util.Scanner;

/**
 * 递归实现求两个正整数的最大公约数和最小公倍数
 * create by qiulisun on 2018/12/27.<br>
 */
public class LeastCommonMultiple {

    public static void main(String[] args){

        //从控制台读取字符串
        Scanner sc = new Scanner(System.in);
        String lineA = sc.nextLine();
        String lineB = sc.nextLine();

        int a = Integer.parseInt(lineA);
        int b = Integer.parseInt(lineB);
        int greatestCommonDivisor = doGreatestCommonDivisor(a, b);
        int leastCommonMultiple = doLeastCommonMultiple(a, b);
        System.out.println("最大公约数是：" + greatestCommonDivisor + "； 最小公倍数是：" + leastCommonMultiple);
    }

    /**
     * 返回最大公约数（使用辗转相除法）
     * @param a
     * @param b
     * @return
     */
    public static int doGreatestCommonDivisor(int a, int b) {

        if (a < b) {
        	int r = 0;
        	r = a;
        	a = b;
        	b = r;
        }

        if (a % b == 0) {
        	return b;
        } else {
            return doGreatestCommonDivisor(b, a%b);
        }
    }

    /**
     * 返回最小公倍数（两数乘积除以最大公约数）
     * @param a
     * @param b
     * @return
     */
    public static int doLeastCommonMultiple(int a, int b) {
        int product = a * b;
        int greatestCommonDivisor = doGreatestCommonDivisor(a, b);
        return product / greatestCommonDivisor;
    }
}
