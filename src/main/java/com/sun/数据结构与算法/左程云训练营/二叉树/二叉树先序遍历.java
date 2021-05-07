package com.sun.数据结构与算法.左程云训练营.二叉树;

import java.util.Stack;

/**
 * create by qiulisun on 2021/4/10.<br>
 *
 * @author 51050
 */
public class 二叉树先序遍历 {
    /**
     * 先序遍历打印二叉树（递归）
     *
     * @param root
     */
    public static void preorder1(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preorder1(root.left);
        preorder1(root.right);
    }

    /**
     * 先序遍历打印二叉树（非递归）
     *
     * @param root
     */
    public static void preorder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }
}
