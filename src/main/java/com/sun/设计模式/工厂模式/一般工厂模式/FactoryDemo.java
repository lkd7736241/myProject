package com.sun.设计模式.工厂模式.一般工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class FactoryDemo {
    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.eat();

        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.eat();
    }
}
