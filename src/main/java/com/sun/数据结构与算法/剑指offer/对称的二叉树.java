package com.sun.数据结构与算法.剑指offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * create by qiulisun on 2021/3/9.<br>
 *
 * @author 51050
 */
public class 对称的二叉树 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return isSame(pRoot.left, pRoot.right);
    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
        }
    }
}
