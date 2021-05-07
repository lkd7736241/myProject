package com.sun.字符串和时间处理方法;

/**
 * 字符串反转
 * create by qiulisun on 2019/4/14.<br>
 */
public class ReverseString {

    public static void main(String[] args){
        String string = "runoob";
        String result = new StringBuffer(string).reverse().toString();
        System.out.println(result);
    }
}
