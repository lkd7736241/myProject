package com.sun.第一季.自增变量;

/**
 * i、j、k都等于几
 * 小结：
 * 1. 赋值运算符=最后计算
 * 2. = 右边的加载值从左到右依次压入操作数栈
 * 3. 实际先算哪个要看运算符优先级
 * 4. 自增、自减操作都是直接修改变量的值，不经过操作数栈
 * 5. 最后赋值之前，中间结果也是存储在操作数栈中
 * create by qiulisun on 2021/10/3.<br>
 */
public class 自增变量 {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i= " + i);
        System.out.println("j= " + j);
        System.out.println("k= " + k);
    }
}
