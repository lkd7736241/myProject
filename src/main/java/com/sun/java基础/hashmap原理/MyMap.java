package com.sun.java基础.hashmap原理;

/**
 * create by qiulisun on 2021/2/24.<br>
 * @author 51050
 */
public interface MyMap {
    String put(String k, String v);
    String get(String k);
    int size();

    interface Entry<K, V>{
        K getKey();
        V getValue();
    }
}
