package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 * <p>
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * 返回匹配的结果，正确输出true，错误输出false
 * <p>
 * 输入：
 * te?t*.*
 * txt12.xls
 * 输出：
 * false
 * <p>
 * create by qiulisun on 2020/12/29.<br>
 *
 * @author 51050
 */
public class 字符串通配符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String source = scanner.next();
            String target = scanner.next();

        }
    }

    private static boolean isMatch(String regular, String target) {
        return true;
    }
}
