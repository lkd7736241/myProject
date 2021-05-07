package com.sun.内部类;

/**
 * create by qiulisun on 2020/12/7.<br>
 */
public class InnerDemo {
    public static void main(String[] args) {
        Out.Inner1 inner1 = new Out.Inner1();
        inner1.write();

        // 成员内部类不能直接初始化，需要外部类先初始化为对象
        Out out = new Out();
        Out.Inner2 inner2 = out.new Inner2();
        inner2.write();

        out.test();
    }
}
