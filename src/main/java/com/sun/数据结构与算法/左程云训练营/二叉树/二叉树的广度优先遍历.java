package com.sun.数据结构与算法.左程云训练营.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * create by qiulisun on 2021/4/10.<br>
 *
 * @author 51050
 */
public class 二叉树的广度优先遍历 {
    /**
     * 利用队列
     *
     * @param root
     */
    public static void BreadthFirstTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                ((LinkedList<TreeNode>) queue).add(node.left);
            }
            if (node.right != null) {
                ((LinkedList<TreeNode>) queue).add(node.right);
            }
        }
    }
}
