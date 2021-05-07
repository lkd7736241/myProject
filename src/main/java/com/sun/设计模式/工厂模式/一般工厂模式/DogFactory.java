package com.sun.设计模式.工厂模式.一般工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
