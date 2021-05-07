package com.sun.数据结构与算法.linkedList;

import java.util.Stack;

/**
 * 反向输出链表
 * create by qiulisun on 2018/12/16.<br>
 */
public class StackPrintLinkedList {
    public static void main(String[] args){

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node1.next = node2;
        node2.next = node3;
        Stack<Node> stack = printListReverse(node1);
        while (!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }

    public static Stack<Node> printListReverse(Node headNode) {
        Stack<Node> stack = new Stack<Node>();
        while (headNode != null){
            stack.push(headNode);
            headNode = headNode.next;
        }
        return stack;
    }
}

class Node{
    public Node next;
    public int data;
}