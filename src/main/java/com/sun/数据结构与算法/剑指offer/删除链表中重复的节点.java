package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.ListNode;

import java.util.HashSet;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 输入：{1,2,3,3,4,4,5}
 * 输出：{1,2,5}
 * create by qiulisun on 2021/3/5.<br>
 *
 * @author 51050
 */
public class 删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet();
        ListNode head = pHead;
        while (pHead != null) {

            if (!set.contains(pHead.getVal())) {
                set.add(pHead.getVal());
                ListNode node = new ListNode(pHead.getVal());
                head.setNext(node);
                head = node;
                pHead = pHead.getNext();
            } else {
                pHead = pHead.getNext();
            }
        }
        return head;
    }
}
