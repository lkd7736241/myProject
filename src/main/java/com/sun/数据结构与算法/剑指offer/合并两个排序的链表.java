package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 输入：{1,3,5},{2,4,6}
 * 输出：{1,2,3,4,5,6}
 * create by qiulisun on 2021/3/5.<br>
 *
 * @author 51050
 */
public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.getVal() >= list2.getVal()) {
            ListNode next = Merge(list1.getNext(), list2);
            list1.setNext(next);
            return list1;
        } else {
            ListNode next = Merge(list1, list2.getNext());
            list2.setNext(next);
            return list2;
        }

    }
}
