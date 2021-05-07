package com.sun.java基础.基础语法;

import java.util.Scanner;

/**
 * 猜数字游戏
 * create by qiulisun on 2021/2/19.<br>
 *
 * @author 51050
 */
public class do_while的用法 {
    public static void main(String[] args) {
        // 记录用户输入的数字
        int guess = -1;
        // 记录用户输入次数
        int count = 0;
        // 生成1-100之间随机数
        int num = (int) (int) (Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);
        // 循环猜数字
        do {
            System.out.println("请输入1-100之间的数字");
            guess = sc.nextInt();
            if (guess > num) {
                System.out.println("哥们，太大了");
            } else if (guess < num) {
                System.out.println("哥们，太小了");
            } else {
                System.out.println("恭喜，中啦");
            }
            count++;
        } while (num != guess);
        System.out.println("你猜测的数字是:" + num + "猜测了" + count + "次");
    }
}
