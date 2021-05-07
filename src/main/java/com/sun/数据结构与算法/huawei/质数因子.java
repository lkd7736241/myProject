package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * <p>
 * <p>
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n>k，但n能被k整除，则应打印出k的值（k为质因子）；并用n除以k的商,作为新的正整数你n；同时k++
 * 　重复执行第一步。
 * (3)如果n不能被k整除，则用k++,重复执行第一步。
 * create by qiulisun on 2020/11/9.<br>
 *
 * @author 51050
 */
public class 质数因子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long aLong = scanner.nextLong();
            printPrime(aLong);
        }
    }

    public static void printPrime(long along) {
        for (int i = 2; i <= along; i++) {
            if (along % i == 0) {
                System.out.println(i + " ");
                printPrime(along / i);
                break;
            }
        }
    }
}
