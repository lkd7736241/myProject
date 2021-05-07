package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 汽水瓶
 * <p>
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
 * 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * create by qiulisun on 2020/10/2.<br>
 * @author 51050
 */
public class SodaBottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int result = doCalc(count);
            if (result == 0) {
                return;
            }
            System.out.println(result);
        }
    }

    private static int doCalc(int i) {
        if (i == 0 || i == 1) {
            return 0;
        } else if (i == 2) {
            return 1;
        } else {
            int i1 = i / 3;
            int i2 = i % 3;

            int i3 = doCalc(i1 + i2);
            int sum = i1 + i3;
            return sum;
        }
    }
}
