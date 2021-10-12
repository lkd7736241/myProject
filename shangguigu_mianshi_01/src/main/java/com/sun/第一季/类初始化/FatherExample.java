package com.sun.第一季.类初始化;

/**
 * create by qiulisun on 2021/10/6.<br>
 */
public class FatherExample {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(1)");
    }

    FatherExample() {
        System.out.println("(2)");
    }

    {
        System.out.println("(3)");
    }

    public int test() {
        System.out.println("(4)");
        return 1;
    }

    public static int method() {
        System.out.println("(5)");
        return 1;
    }
}
