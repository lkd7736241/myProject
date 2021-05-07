package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 百钱买百鸡
 * <p>
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 算法思路：5x+3y+1/3z=100;
 * x+y+z=100;
 * 上面两个式子化简可得：7x+4y=100;0<=x<=14，0<=y<=25
 * 注意：要将3种鸡作为一个整体考虑，而不能只考虑其中一种的限制条件
 * create by qiulisun on 2020/10/6.<br>
 * @author 51050
 */
public class TheMoneyToBuyTheBestChicken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int n1 = 0; n1 < 14; n1++) {
                for (int n2 = 0; n2 <= 25; n2++) {
                    if (7 * n1 + 4 * n2 == 100) {
                        int n3 = 100 - n1 - n2;
                        System.out.println(n1 + " " + n2 + " " + n3);
                    }
                }
            }
        }
        sc.close();
    }
}
