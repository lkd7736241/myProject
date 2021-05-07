package com.sun.数据结构与算法.左程云训练营;

import java.util.Stack;

/**
 * 【题目】给定一个单链表的头节点head，请判断该链表是否为回文结构。
 * 【例子】1->2->1，返回true； 1->2->2->1，返回true；15->6->15，返回true；1->2->3，返回false。
 * 【例子】如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 * 方法1：放入栈中
 * 方法2：快慢指针:快指针到表尾部，满指针到表中部（额外空间复杂度达到O(1)）
 * create by qiulisun on 2021/4/8.<br>
 *
 * @author 51050
 */
public class 判断链表是否为回文结构 {
    public static boolean isPalindrome1(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (head == null) {
            return true;
        }

        Node fast = head;
        Node slow = head.next;
        while (fast.next != null && slow.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


}
