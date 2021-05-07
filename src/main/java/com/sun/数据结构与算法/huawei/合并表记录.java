package com.sun.数据结构与算法.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的整数），
 * 请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * 输出合并后的键值对（多行）
 * <p>
 * create by qiulisun on 2020/11/9.<br>
 *
 * @author 51050
 */
public class 合并表记录 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if (treeMap.containsKey(key)) {
                    value += treeMap.get(key);
                    treeMap.put(key, value);
                } else {
                    treeMap.put(key, value);
                }
            }

            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
