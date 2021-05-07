package com.sun.设计模式.工厂模式.简单工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        SimpleAnimal dog = SimpleAnimalFactory.createAnimal("dog");
        dog.eat();

        SimpleAnimal cat = SimpleAnimalFactory.createAnimal("cat");
        cat.eat();
    }
}
