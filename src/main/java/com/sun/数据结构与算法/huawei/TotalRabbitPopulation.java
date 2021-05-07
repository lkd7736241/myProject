package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 兔子的总数
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * <p>
 * 新生的兔子从第三个月开始生小兔子，即当月兔子数=上个月兔子数+上上个月兔子数（可以生小兔子的兔子数）
 * create by qiulisun on 2020/10/2.<br>
 * @author 51050
 */
public class TotalRabbitPopulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int totalCount = getTotalCount(month);
        System.out.println(totalCount);
    }

    /**
     * 统计出兔子总数。
     *
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount) {
        if (monthCount == 1) {
            return 1;
        } else if (monthCount == 2) {
            return 1;
        } else {
            return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
        }
    }
}
