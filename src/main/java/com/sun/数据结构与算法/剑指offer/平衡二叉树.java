package com.sun.数据结构与算法.剑指offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * <p>
 * create by qiulisun on 2020/11/28.<br>
 */
public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (getDepth(root) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if ((leftDepth - rightDepth < -1) || (leftDepth - rightDepth > 2)) {
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
