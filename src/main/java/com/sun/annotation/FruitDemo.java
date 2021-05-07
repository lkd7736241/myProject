package com.sun.annotation;

import java.lang.reflect.Field;

/**
 * create by qiulisun on 2020/12/7.<br>
 */
public class FruitDemo {
    public static void main(String[] args) throws Exception {
        getFruitInfo(Apple.class);
    }

    public static void getFruitInfo(Class<?> clazz) throws NoSuchFieldException {
        Field appleStr = clazz.getDeclaredField("appleStr");
        if (appleStr.isAnnotationPresent(FruitAnnotation.class)) {
            FruitAnnotation annotation = appleStr.getAnnotation(FruitAnnotation.class);
            System.out.println("供应商编号：" + annotation.id() + ", 供应商名称：" + annotation.name() +
                    ", 供应商地址：" + annotation.address());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitAnnotation.class)) {
                FruitAnnotation annotation = field.getAnnotation(FruitAnnotation.class);
                System.out.println("供应商编号：" + annotation.id() + ", 供应商名称：" + annotation.name() +
                        ", 供应商地址：" + annotation.address());
            }
        }
    }
}
