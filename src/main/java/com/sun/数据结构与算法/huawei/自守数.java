package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。
 * 请求出n以内的自守数的个数
 * create by qiulisun on 2021/2/21.<br>
 *
 * @author 51050
 */
public class 自守数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();

            int result = calcAutomorphicNumbers(input);
            System.out.println(result);
        }
    }

    public static int calcAutomorphicNumbers(int input) {
        if (input == 0) {
            return 1;
        }

        int result = 1;
        for (Integer i = 1; i <= input; i++) {
            Integer square = i * i;
            String temp = i.toString();
            String squareStr = square.toString();

            String substring = squareStr.substring(squareStr.length() - temp.length());
            if (substring.equals(temp)) {
                result++;
            }
        }
        return result;
    }
}
