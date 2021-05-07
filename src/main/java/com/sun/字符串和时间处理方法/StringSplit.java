package com.sun.字符串和时间处理方法;

import org.springframework.util.StringUtils;

/**
 * 字符串分割
 * create by qiulisun on 2019/4/21.<br>
 */
public class StringSplit {

    public static final String POINT_SEPARATOR = "\\.";

    public static void main(String[] args){
        String target = "www.runoob.com";
        String separator = POINT_SEPARATOR;
        String[] result = doStringSplit(target, separator);
        for (String s : result) {
            System.out.println(s);
        }
    }


    private static String[] doStringSplit(String target, String separator) {
        if (StringUtils.isEmpty(target) || StringUtils.isEmpty(separator)) {
            return null;
        }
        String[] split = target.split(separator);
        return split;
    }
}
