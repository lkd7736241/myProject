package com.sun.数据结构与算法.剑指offer;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * create by qiulisun on 2020/11/28.<br>
 */
public class 二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
