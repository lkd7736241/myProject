package com.sun.数据结构与算法.左程云训练营.二叉树;

import java.util.Stack;

/**
 * create by qiulisun on 2021/4/10.<br>
 *
 * @author 51050
 */
public class 二叉树后序遍历 {
    /**
     * 先序': 头右左
     * 后序 ; 左右头
     * 利用先序’的倒序
     *
     * @param root
     */
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right != null) {
                stack1.push(pop.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }
}
