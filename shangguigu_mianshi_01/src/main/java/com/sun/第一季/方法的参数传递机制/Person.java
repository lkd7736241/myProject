package com.sun.第一季.方法的参数传递机制;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * create by qiulisun on 2021/10/19.<br>
 */
@Getter
@Setter
@AllArgsConstructor
public class Person {
    private Integer id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }
}
