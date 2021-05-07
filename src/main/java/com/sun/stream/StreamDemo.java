package com.sun.stream;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by qiulisun on 2019/2/18.<br>
 */
public class StreamDemo {
    public static void main(String[] args){
        long count = 0;

        System.out.println("-----使用 Java 7-----");

        List<String> strings = Arrays.asList("abc", "bc", "efg", "abcd", "", "jkl");
        System.out.println("使用 Java 7；列表:" + strings);

        //计算list空字符串的个数
        count = getEmptyStringCount(strings);
        System.out.println("使用 Java 7；空字符数量为: " + count);
        //计算长度为3的字符串的个数
        count = getLength3StringCount(strings);
        System.out.println("使用 Java 7；长度为3的字符串的数量为：" + count);
        //删除空字符串
        List<String> deleteEmptyString = deleteEmptyString(strings);
        System.out.println("使用 Java 7；删除空字符串后：" + deleteEmptyString);
        // 删除空字符串，并使用逗号把剩下的字符合并起来
        String deleteEmptyStringAndJoinWhitComma = deleteEmptyStringAndJoinWhitComma(strings);
        System.out.println("使用 Java 7；删除空字符串，并使用逗号把剩下的字符合并起来：" + deleteEmptyStringAndJoinWhitComma);

        System.out.println("-----使用 Java 8:-----");
        System.out.println("使用 Java 8:列表: " +strings);
        //计算list空字符串的个数
        count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("使用 Java 8:空字符串数量为: " + count);
        //计算长度为3的字符串的个数
        count = strings.stream().filter(str -> (str.length() == 3)).count();
        System.out.println("使用 Java 8:长度为3的字符串的数量为：" + count);
        //删除空字符串
        deleteEmptyString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("使用 Java 8:删除空字符串后：" + deleteEmptyString);
        // 删除空字符串，并使用逗号把剩下的字符合并起来
        String deleteEmptyStringAndJoinWhitComma8 = strings.stream().filter(str -> !str.isEmpty()).
                collect(Collectors.joining(","));
        System.out.println("使用 Java 8:删除空字符串，并使用逗号把剩下的字符合并起来："
                + deleteEmptyStringAndJoinWhitComma8);
    }

    /**
     * 删除空字符串，并使用逗号把剩下的字符合并起来
     * @param strings
     * @return
     */
    private static String deleteEmptyStringAndJoinWhitComma(List<String> strings) {
        String result = "";
        List<String> temp = new ArrayList<>();
        for (String string : strings) {
            if (string.isEmpty()) {
            	continue;
            } else {
                temp.add(string);
            }
        }
        result = StringUtils.join(temp, ",");
        return result;
    }

    /**
     * 计算长度为3的字符串的个数
     * @param strings
     * @return
     */
    private static int getLength3StringCount(List<String> strings) {
        int result = 0;
        for (String string : strings) {
            if (string.length() == 3) {
                result++;
            }
        }
        return result;
    }

    /**
     * 删除空字符串
     * @param strings
     * @return
     */
    public static List<String> deleteEmptyString(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            if (!string.isEmpty()) {
                result.add(string);
            }
        }
        return result;
    }

    /**
     * 获取空字符串的个数
     * @param strings
     * @return
     */
    public static int getEmptyStringCount(List<String> strings) {
        int count = 0;
        for (String str : strings) {
            if (str.isEmpty()) {
            	count++;
            }
        }
        return count;
    }
}
