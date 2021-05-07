package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 最小公倍数
 * <p>
 * create by qiulisun on 2020/11/4.<br>
 *
 * @author 51050
 */
public class 最小公倍数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            Long aLong = Long.valueOf(split[0]);
            Long bLong = Long.valueOf(split[1]);

            long dividend = aLong;
            long divisor = bLong;

            // 先用辗转相除法求最大公约数
            long minCommonDiv = 0L;
            while (divisor != 0L) {
                long remainder = dividend % divisor;
                if (remainder != 0) {
                    dividend = divisor;
                    divisor = remainder;
                } else {
                    minCommonDiv = divisor;
                    break;
                }
            }

            long result = 0L;
            if (minCommonDiv != 0) {
                result = (aLong * bLong) / minCommonDiv;
            }
            System.out.println(result);
        }
    }
}
