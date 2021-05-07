package com.sun.内部类;

/**
 * create by qiulisun on 2020/12/7.<br>
 */
public class Out {
    private static int a;
    private int b;

    public static class Inner1 {
        public void write() {
            System.out.println(a);
        }
    }

    public class Inner2 {
        public void write() {
            System.out.println(a);
            System.out.println(b);
        }
    }

    public void test() {
        class Inner3 {
            public void name() {
                System.out.println("inner3");
            }
        }
    }
}
