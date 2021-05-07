package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.ListNode;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 输入：{1,2,3,4,5},1
 * 输出：{5}
 * create by qiulisun on 2021/3/5.<br>
 *
 * @author 51050
 */
public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (k < 1) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.getNext();
        }
        if (k > stack.size()) {
            return null;
        }
        return stack.get(stack.size() - k);
    }
}
