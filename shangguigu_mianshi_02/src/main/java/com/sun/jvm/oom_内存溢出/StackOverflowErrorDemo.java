package com.sun.jvm.oom_内存溢出;

/**
 * 递归调用无结束条件
 * <p>
 * java.lang.StackOverflowError
 * <p>
 * create by qiulisun on 2021/10/26.<br>
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverFlowError();
    }

    private static void stackOverFlowError() {
        stackOverFlowError();
    }
}
