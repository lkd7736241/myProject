package com.sun.设计模式.代理模式.透明代理;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class TransparentJavaProgrammer implements TransparentProgrammer {
    @Override
    public void coding() {
        System.out.println("透明：java 程序员写代码");
    }
}
