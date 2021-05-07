package com.sun.数据结构与算法.huawei;

import java.util.*;

/**
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 输入：aaddccdc
 * 1b1bbbbbbbbb
 * 输出：cda
 * b1
 * <p>
 * create by qiulisun on 2020/12/18.<br>
 *
 * @author 51050
 */
public class 字符统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] chars = str.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                if (map.containsKey(aChar)) {
                    Integer num = map.get(aChar);
                    map.put(aChar, num + 1);
                } else {
                    map.put(aChar, 1);
                }
            }

            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

            list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    int compareValue = o2.getValue().compareTo(o1.getValue());
                    if (compareValue == 0) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return compareValue;
                    }
                }
            });

            StringBuffer buffer = new StringBuffer();
            for (Map.Entry<Character, Integer> entry : list) {
                buffer.append(entry.getKey());
            }

            System.out.println(buffer.toString());
        }
    }
}
