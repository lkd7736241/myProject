package com.sun.字符串和时间处理方法;

/**
 * 字符串搜索
 * create by qiulisun on 2019/4/15.<br>
 */
public class SearchString {

    public static void main(String[] args){
        String string = "runoob";
        int result = string.indexOf("n");
        if (result == -1) {
            System.out.println("未找到");
        } else {
            System.out.println("字符串在 ：" + result);
        }
    }
}
