package com.sun.数据结构与算法.剑指offer;

import java.util.Scanner;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * f[n] = f[n-1] + f[n-2]，初始条件f[1] = 1, f[2] =2
 * <p>
 * create by qiulisun on 2020/11/19.<br>
 */
public class 矩形覆盖 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            int res = RectCover(anInt);
            System.out.println(res);
        }
    }

    public static int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int res = RectCover(target - 1) + RectCover(target - 2);
        return res;
    }
}
