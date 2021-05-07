package com.sun.设计模式.工厂模式.抽象工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 */
public class AbsFactoryDemo {
    public static void main(String[] args) {
        FemaleAnimalFactory femaleAnimalFactory = new FemaleAnimalFactory();
        AbsAnimal femaleCat = femaleAnimalFactory.createCat();
        femaleCat.eat();
        femaleCat.gender();
        AbsAnimal femaleDog = femaleAnimalFactory.createDog();
        femaleDog.eat();
        femaleDog.gender();

        MaleAnimalFactory maleAnimalFactory = new MaleAnimalFactory();
        AbsAnimal maleCat = maleAnimalFactory.createCat();
        maleCat.eat();
        maleCat.gender();
        AbsAnimal maleDog = maleAnimalFactory.createDog();
        maleDog.eat();
        maleDog.gender();
    }
}
