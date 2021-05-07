package com.sun.设计模式.工厂模式.抽象工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 * @author 51050
 */
public class FemaleAnimalFactory implements AbsAnimalFactory {
    @Override
    public AbsAnimal createCat() {
        return new FemaleCat();
    }

    @Override
    public AbsAnimal createDog() {
        return new FemaleDog();
    }
}
