package com.sun.数据结构与算法.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * create by qiulisun on 2021/1/9.<br>
 *
 * @author 51050
 */
public class 连续自然数之和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int anInt = scanner.nextInt();
            Map<Integer, Integer> sumMap = getSum(anInt);
            for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
                for (int i = entry.getKey(); i < entry.getValue(); i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * 我们枚举连续正整数的开始值 start，并进行累加，直到结果大于等于 N。如果结果刚好等于 N，我们就找到了一组答案。
     * 例如当 N = 6 时，若开始值为 1，我们会累加得到 1 + 2 + 3 = 6，得到一组答案；若开始值为 2，我们会累加得到 2 + 3 + 4 = 9，超出了 6。以此类推，直到开始值超过 N。
     *
     * 这种方法会超出时间限制。
     * @param anInt
     * @return
     */
    private static Map<Integer, Integer> getSum(int anInt) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= anInt; ++i) {
            int target = anInt;
            int x = i;
            while (target > 0) {
                target -= x;
                x++;
            }
            if (target == 0) {
                map.put(i, x);
            }
        }
        return map;
    }


}
