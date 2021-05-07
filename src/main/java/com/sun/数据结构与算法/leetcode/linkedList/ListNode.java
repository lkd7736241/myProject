package com.sun.数据结构与算法.leetcode.linkedList;

/**
 * create by qiulisun on 2019/5/4.<br>
 */
public class ListNode {
    private String value;
    private ListNode next;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListNode{");
        sb.append("value='").append(value).append('\'');
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
