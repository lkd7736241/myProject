package com.sun.java基础.hashmap原理;

/**
 * create by qiulisun on 2021/2/24.<br>
 * @author 51050
 */
public class MyHashMap implements MyMap{

    private Entry<String, String> table[] = null;

    public MyHashMap() {
        this.table = new Entry[16];
    }

    @Override
    public String put(String k, String v) {
        return null;
    }

    @Override
    public String get(String k) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    class Entry<K, V> implements MyMap.Entry<K, V> {

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }
}
