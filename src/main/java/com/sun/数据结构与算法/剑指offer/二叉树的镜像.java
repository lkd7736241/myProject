package com.sun.数据结构与算法.剑指offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 比如：    源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * 输入：{8,6,10,5,7,9,11}
 * 输出：{8,10,6,11,9,7,5}
 * create by qiulisun on 2021/3/6.<br>
 *
 * @author 51050
 */
public class 二叉树的镜像 {
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        // 如果左右子节点不为空，将其递归
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
