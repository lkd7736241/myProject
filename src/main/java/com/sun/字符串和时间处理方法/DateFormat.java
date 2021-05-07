package com.sun.字符串和时间处理方法;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化
 * create by qiulisun on 2019/4/27.<br>
 */
public class DateFormat {
    public static void main(String[] args){
        //定义时间格式
        String dateFormatStr = "yyyy-MM-dd HH:mm:ss";
        //定义格式化时间的对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatStr);
        //格式化时间
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
