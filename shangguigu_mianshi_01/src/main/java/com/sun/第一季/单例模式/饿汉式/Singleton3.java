package com.sun.第一季.单例模式.饿汉式;

import java.io.IOException;
import java.util.Properties;

/**
 * 单例模式的实现要点：1. 某个类智能有一个实例；2. 它必须自行创建该示例；3. 它必须向整个系统提供这个实例
 * <p>
 * 2) 静态代码块实现（用于比较复杂的实现，例如加载配置文件中的信息）
 * create by qiulisun on 2021/10/5.<br>
 */
public class Singleton3 {
    //    简单的例子
    //    public static final Singleton3 instance;
    //
    //    static {
    //        instance = new Singleton3();
    //    }
    //
    //    private Singleton3() {
    //    }

    public static final Singleton3 INSTANCE;

    private String info;

    static {
        try {
            Properties properties = new Properties();
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("单例模式/single.properties"));
            INSTANCE = new Singleton3(properties.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Singleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
