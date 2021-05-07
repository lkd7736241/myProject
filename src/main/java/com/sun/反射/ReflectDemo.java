package com.sun.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by qiulisun on 2019/1/4.<br>
 *
 * @author 51050
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
//        Class<?> cls = Person.class;
        Class<?> cls = Class.forName("com.sun.反射.Person");
        try {
            Object obj = cls.newInstance();
            Method setName = cls.getDeclaredMethod("setName", String.class);
            setName.invoke(obj, "张三");
            System.out.println(obj.toString());
            System.out.println("==========================");

            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
                System.out.println("==========================");
            }

            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
                System.out.println("==========================");
            }

            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.toString());
                System.out.println("==========================");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
