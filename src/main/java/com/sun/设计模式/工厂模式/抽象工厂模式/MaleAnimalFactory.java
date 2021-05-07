package com.sun.设计模式.工厂模式.抽象工厂模式;

/**
 * create by qiulisun on 2020/12/16.<br>
 * @author 51050
 */
public class MaleAnimalFactory implements AbsAnimalFactory {
    @Override
    public AbsAnimal createCat() {
        return new MaleCat();
    }

    @Override
    public AbsAnimal createDog() {
        return new MaleDog();
    }
}
