package com.sun.数据结构与算法.剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 示例
 * 输入：{5,4,#,3,#,2,#,1}
 * 输出：[5,4,3,2,1]
 * create by qiulisun on 2021/3/7.<br>
 *
 * @author 51050
 */
public class 从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            res.add(temp.val);
        }

        return res;
    }
}
