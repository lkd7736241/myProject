package com.sun.jvm类加载机制;

/**
 * create by qiulisun on 2020/12/3.<br>
 */
public class FileClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        FileClassLoader fileClassLoader = new FileClassLoader();
        Class<?> clazz = fileClassLoader.loadData("com.sun.vo.ListNode");
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);
//        clazz.getMethod("ListNode", 1000);
    }
}
