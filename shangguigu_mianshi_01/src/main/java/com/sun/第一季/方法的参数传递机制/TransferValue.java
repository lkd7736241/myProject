package com.sun.第一季.方法的参数传递机制;

/**
 * create by qiulisun on 2021/10/19.<br>
 */
public class TransferValue {
    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        int age = 20;
        transferValue.changeValue1(age);
        System.out.println("age----" + age);

        Person person = new Person("abc");
        transferValue.changeValue2(person);
        System.out.println("personName---" + person.getPersonName());

        String str = "abc";
        transferValue.changeValue3(str);
        System.out.println("string---" + str);
    }

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }
}
