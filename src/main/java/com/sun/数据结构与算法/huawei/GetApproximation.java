package com.sun.数据结构与算法.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 取近似值
 *
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * create by qiulisun on 2020/10/1.<br>
 * @author 51050
 */
public class GetApproximation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float aFloat = scanner.nextFloat();
        if (aFloat < 0) {
        	System.out.println("the param is smaller then 0");
        }
        BigDecimal bigDecimal = new BigDecimal(aFloat);
        BigDecimal scale = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(scale);
    }
}
