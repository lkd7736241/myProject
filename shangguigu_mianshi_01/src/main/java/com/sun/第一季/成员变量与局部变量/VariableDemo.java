package com.sun.第一季.成员变量与局部变量;

/**
 * 局部变量和成员变量
 * create by qiulisun on 2021/10/7.<br>
 */
public class VariableDemo {
    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        VariableDemo obj1 = new VariableDemo();
        VariableDemo obj2 = new VariableDemo();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }
}
