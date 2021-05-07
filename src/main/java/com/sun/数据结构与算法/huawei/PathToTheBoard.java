package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
 * 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 递归：f(m,n) = f(m-1,n) + f(m,n-1)
 * 注意：但凡是触碰到边界，也就是说f(x, 0)或者f(0,x)都只有一条直路可走了
 * <p>
 * create by qiulisun on 2020/11/6.<br>
 *
 * @author 51050
 */
public class PathToTheBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int methodCount = getMethodCount(m, n);
            System.out.println(methodCount);
        }
    }

    private static int getMethodCount(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        return getMethodCount(m - 1, n) + getMethodCount(m, n - 1);
    }
}
