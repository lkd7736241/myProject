package com.sun.字符串和时间处理方法;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间戳
 * create by qiulisun on 2019/4/27.<br>
 */
public class TheTimeStamp {
    public static void main(String[] args){
        long timeStamp = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(new Date(timeStamp));
        System.out.println("格式化结果：" + format1);

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        String format2 = simpleDateFormat2.format(new Date(timeStamp));
        System.out.println("格式化结果：" + format2);
    }
}
