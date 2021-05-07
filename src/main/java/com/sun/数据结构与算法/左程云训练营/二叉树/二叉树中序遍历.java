package com.sun.数据结构与算法.左程云训练营.二叉树;

import java.util.Stack;

/**
 * create by qiulisun on 2021/4/10.<br>
 */
public class 二叉树中序遍历 {
    /**
     * 1. 将树的左边界（不是左子树）全部入栈
     * 2. 顺序弹出元素，弹出时打印，并且将该元素的右孩子
     *
     * @param root
     */
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                root = root.right;
            }
        }
    }
}
