package com.sun.数据结构与算法.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * create by qiulisun on 2021/2/19.<br>
 *
 * @author 51050
 */
public class 求解立方根 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double aDouble = scanner.nextDouble();
            double cube = getCube(aDouble);
            BigDecimal bigDecimal = new BigDecimal(cube);
            double result = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            System.out.println(result);
        }
    }

    public static double getCube(double input) {
        double min = 0;
        double max = input;
        double mid = 0;

        while ((max - min) > 0.001) {
            mid = (max + min) / 2;
            if (mid * mid * mid > input) {
                max = mid;
            } else if (mid * mid * mid < input) {
                min = mid;
            } else {
                return mid;
            }
        }
        return max;
    }
}
