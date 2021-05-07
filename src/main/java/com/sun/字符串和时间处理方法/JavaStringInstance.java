package com.sun.字符串和时间处理方法;

/**
 * java实例
 * create by qiulisun on 2019/4/13.<br>
 */
public class JavaStringInstance {
    public static void main(String[] args){
        /* 查找字符串最后一次出现的位置 */
        String original = "Hello world, hello runoob";
        String target = "runoob";
        int searchlastStrResult = searchlastStr(original, target);
        System.out.println("字符串最后出现的位置是: " + searchlastStrResult);
        /* 删除字符串中的一个字符 */
        String removeCharAtStr = "jintianbukaixin";
        int pos = 5;
        String removeCharAtResult = removeCharAt(removeCharAtStr, pos);
        System.out.println("删除字符串中的一个字符: " + removeCharAtResult);
        /* 字符串替换 */
        String replaceEmpString = "hello world";
        System.out.println(replaceEmpString.replace("l", "i"));
        System.out.println(replaceEmpString.replaceFirst("l", "i"));
        System.out.println(replaceEmpString.replaceAll("l", "i"));
//        stringReplaceEmp(replaceEmpString);
    }

    /**
     * 查找字符串最后一次出现的位置
     * @param original
     * @param target
     * @return
     */
    private static int searchlastStr(String original, String target) {
        int lastIndex = original.lastIndexOf(target);
        return lastIndex;
    }

    /**
     * 删除字符串中的一个字符
     * @param s
     * @param pos
     * @return
     */
    private static String removeCharAt(String s, int pos) {
        String result = s.substring(0, pos) + s.substring(pos + 1);
        return result;
    }

    /**
     * 字符串替换
     * 以下实例中我们使用 java String 类的 replace 方法来替换字符串中的字符：
     * @param target
     */
    private static void stringReplaceEmp(String target) {
        target.replace("h", "i");
        System.out.println(target);
        target.replaceFirst("l", "i");
        System.out.println(target);
        target.replaceAll("l", "i");
        System.out.println(target);
    }

}
