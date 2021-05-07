package com.sun.数据结构与算法.剑指offer;

import java.util.Stack;

/**
 * push操作：直接push进stack1
 * pop操作：先判断stack2中是否有数据，若有则直接弹出，若没有则将stack1中的数据全部放进stack2中再弹出
 * <p>
 * create by qiulisun on 2020/11/17.<br>
 *
 * @author 51050
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        } else {
            return stack2.pop();
        }
        return stack2.pop();
    }
}
