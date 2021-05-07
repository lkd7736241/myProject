package com.sun.字符串和时间处理方法;

import java.util.Calendar;
import java.util.Date;

/**
 * 获取年份、月份等
 * create by qiulisun on 2019/4/27.<br>
 */
public class GetYearsAndMonth {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        Date timeOfCurrent = calendar.getTime();

        System.out.println("当前时间：" + timeOfCurrent);
        System.out.println("日期：" + day);
        System.out.println("月份：" + month);
        System.out.println("年份：" + year);
        System.out.println("是当前周的第几天：" + dayOfWeek);
        System.out.println("是当前月的第几天：" + dayOfMonth);
        System.out.println("是当前年的第几天：" + dayOfYear);
    }
}
