package com.sun.jvm.java中四种引用类型;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMap 若key为null，gc后节点将被收回
 * <p>
 * create by qiulisun on 2021/10/26.<br>
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Integer key1 = new Integer(1);
        String value = "hashmap";

        map.put(key1, value);
        System.out.println(map);
        key1 = null;

        System.gc();
        System.out.println(map);

        System.out.println("===============");

        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key2 = new Integer(2);
        weakHashMap.put(key2, value);
        System.out.println(weakHashMap);
        key2 = null;
        System.gc();
        System.out.println(weakHashMap);
    }
}
