package com.sun.设计模式.工厂模式.简单工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class SimpleAnimalFactory {
    public static SimpleDog CreateDog() {
        return new SimpleDog();
    }

    public static SimpleCat createCat() {
        return new SimpleCat();
    }

    public static SimpleAnimal createAnimal(String type) {
        if ("cat".equals(type)) {
            return new SimpleCat();
        } else if ("dog".equals(type)) {
            return new SimpleDog();
        } else {
            return null;
        }
    }

}
