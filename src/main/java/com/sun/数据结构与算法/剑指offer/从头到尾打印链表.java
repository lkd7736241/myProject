package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 * 输入：{67,0,24,58}
 * 输出：[58,24,0,67]
 * create by qiulisun on 2021/3/5.<br>
 *
 * @author 51050
 */
public class 从头到尾打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.getVal());
            listNode = listNode.getNext();
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

}
