package com.sun.字符串和时间处理方法;

/**
 * 字符串小写转大写
 * create by qiulisun on 2019/4/21.<br>
 */
public class StringToUpperCase {
    public static void main(String[] args){
        String target = "runoob";
        String upperCase = target.toUpperCase();
        String lowerCase = upperCase.toLowerCase();
        System.out.println("原字符串: " + target);
        System.out.println("大写字符串: " + upperCase);
        System.out.println("小写字符串: " + lowerCase);
    }
}
