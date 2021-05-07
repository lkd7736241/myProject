package com.sun.数据结构与算法.leetcode.linkedList;

/**
 * 删除链表中的节点
 * create by qiulisun on 2019/5/4.<br>
 * @author 51050
 */
public class DeleteNode {
    public static void main(String[] args){
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.setNext(node2);
        node2.setNext(node3);
        node1.setValue("node1");
        node2.setValue("node2");
        node3.setValue("node3");
        doDeleteNode(node2);
    }

    private static void doDeleteNode(ListNode node) {
        String value = node.getNext().getValue();
        node.setValue(value);
        ListNode next = node.getNext().getNext();
        node.setNext(next);
    }
}
