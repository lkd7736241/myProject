package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 日期到天数转换
 * 根据输入的日期，计算是这一年的第几天
 * <p>
 * create by qiulisun on 2020/11/8.<br>
 *
 * @author 51050
 */
public class TheDateConversionDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            if (split.length != 3) {
                System.out.println(-1);
            }

            Long year = Long.valueOf(split[0]);
            Long month = Long.valueOf(split[1]);
            Long day = Long.valueOf(split[2]);

            int num = 0;
            for (int i = 1; i < month; i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        num += 31;
                        break;
                    case 2:
                        num += ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
                        break;
                    default:
                        num += 30;
                        break;
                }
            }

            num += day;
            System.out.println(num);
        }
    }
}
