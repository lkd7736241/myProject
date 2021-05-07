package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 * 输入：
 * Jkdi234klowe90a3
 * 5151
 * 输出：
 * Jkdi*234*klowe*90*a*3*
 * *5151*
 * create by qiulisun on 2020/12/29.<br>
 *
 * @author 51050
 */
public class 表示数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            StringBuffer buffer = getStringBuffer1(str);
            System.out.println(buffer.toString());
        }
    }

    /**
     * 使用正则表达式实现
     * @param str
     * @return
     */
    private static String getRegularExpressions(String str) {
        return str.replaceAll("[0-9]+)", "*$1*");
    }

    /**
     * 使用stringBuffer实现
     *
     * @param str
     * @return
     */
    private static StringBuffer getStringBuffer1(String str) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); ) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                buffer.append("*");
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    buffer.append(str.charAt(i++));
                }
                buffer.append("*");
            } else {
                buffer.append(str.charAt(i++));
            }
        }
        return buffer;
    }
}
