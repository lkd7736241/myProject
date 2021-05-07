package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.ListNode;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 输入：{1,2,3}
 * 输出：{3,2,1}
 * create by qiulisun on 2020/11/20.<br>
 *
 * @author 51050
 */
public class 反转链表 {
//    public static ListNode ReverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode reversedHead = null;
//        ListNode current = head;
//        ListNode tmp = null;
//        ListNode pre = null;
//        while (current != null) {
//            tmp = current.getNext();
//            current.getNext() = pre;
//            if (tmp == null)
//                reversedHead = current;
//            pre = current;
//            current = tmp;
//
//        }
//        return reversedHead;
//    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }

        return stack.pop();
    }
}
