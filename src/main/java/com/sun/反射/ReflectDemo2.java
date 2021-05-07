package com.sun.反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * create by qiulisun on 2021/3/2.<br>
 *
 * @author 51050
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        // 创建对象
        Person person = new Person();
        Class<? extends Person> clazz = person.getClass();
        // 根据属性名称获取该对象的某个属性
        Field field = clazz.getDeclaredField("name");
        // 设置权限
        field.setAccessible(true);
        // 获取该属性的名称
        String name = field.getName();
        // 将该属性名称的第一个字母改为大写
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        // 设置方法名称（setXxx）
        String setMethodName = "set" + name;
        // 通过方法注入
        Method method = clazz.getMethod(setMethodName, String.class);
        // 用反射的方式调用该方法
        method.invoke(person, "zhangsan");

        System.out.println(person.getName());
    }
}
