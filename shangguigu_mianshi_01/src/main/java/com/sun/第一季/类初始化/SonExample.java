package com.sun.第一季.类初始化;

/**
 * 1. 类初始化的过程：
 * a.main方法所在的类要先初始化
 * b.初始化子类之前要先初始化父类
 * c.按照代码顺序加载静态资源（静态变量、静态代码块、静态方法）
 * d.只执行一次
 * 2. 实例（对象）初始化过程：
 * a.可以多次执行，执行几次由构造器决定
 * b.按照代码顺序加载非静态资源（非静态变量、非静态代码块），构造方法最后执行
 * c.在执行子类构造方法时默认要先执行一次父类构造方法（即super(),这一方法不写也默认被执行）
 * 3. 方法的重写规则
 * 1）哪些方法不可以被重写
 * a.final声明的方法
 * b.static声明的方法
 * c.private声明的子类不可访问的方法
 * 2）对象的多态性
 * a.子类如果重写了父类的方法，通过子类对象调用的一定是重写后的方法
 * b.非静态方法默认的调用对象是this
 * this对象在init()方法中就是正在创建的对象
 * <p>
 * create by qiulisun on 2021/10/6.<br>
 */
public class SonExample extends FatherExample {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(6)");
    }

    SonExample() {
//        super();
        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }

    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        SonExample s1 = new SonExample();
        System.out.println();
        SonExample s2 = new SonExample();
    }
}
