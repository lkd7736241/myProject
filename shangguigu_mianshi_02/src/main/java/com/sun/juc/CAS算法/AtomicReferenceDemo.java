package com.sun.juc.CAS算法;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 * <p>
 * create by qiulisun on 2021/10/14.<br>
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        MyUser zhangsan = new MyUser("zhangsan", 22);
        MyUser lisi = new MyUser("lisi", 25);
        MyUser wangwu = new MyUser("wangwu", 27);

        AtomicReference<MyUser> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zhangsan);

        System.out.println(userAtomicReference.compareAndSet(zhangsan, lisi) + "\t"
                + userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(zhangsan, wangwu) + "\t"
                + userAtomicReference.get().toString());
    }
}

@AllArgsConstructor
@Getter
@Setter
@ToString
class MyUser {
    String username;
    int age;
}