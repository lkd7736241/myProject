package com.sun.数据结构与算法.leetcode;

import java.util.*;

/**
 * 两个数组的交集 II<br>
 * 给定两个数组，编写一个函数来计算它们的交集。<br>
 * 说明：<br>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。<br>
 * 我们可以不考虑输出结果的顺序。<br>
 * create by qiulisun on 2019/3/16.<br>
 */
public class Intersect {

    public static void main(String[] args){

    }

    /**
     * 自己实现的
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersectPart = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num1 : nums1) {
            if (map1.containsKey(num1)) {
                map1.put(num1, map1.get(num1) + 1);
            } else {
                map1.put(num1, 1);
            }
        }
        for (int num2 : nums2) {
            if (map2.containsKey(num2)) {
                map2.put(num2, map2.get(num2) + 1);
            } else {
                map2.put(num2, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                	if (entry1.getValue() > entry2.getValue()) {
                        for (int i = 0; i < entry2.getValue(); i++) {
                            intersectPart.add(entry2.getKey());
                        }
                	} else {
                        for (int i = 0; i < entry1.getValue(); i++) {
                            intersectPart.add(entry1.getKey());
                        }
                    }
                }
            }
        }
        int[] result = new int[intersectPart.size()];
        if (intersectPart.size() > 0) {
            for (int i = 0; i < intersectPart.size(); i++) {
                result[i] = intersectPart.get(i);
            }
            return result;
        }
        return new int[0];
    }

    /**
     * 网上实现的
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectTheAnswer(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersectPart = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersectPart.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[intersectPart.size()];
        if (intersectPart.size() > 0) {
            for (int k = 0; k < intersectPart.size(); k++) {
                result[k] = intersectPart.get(k);
            }
            return result;
        }
        return new int[0];
    }
}
