package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.TreeNode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 输入：[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 输出：{1,2,5,3,4,6,7}
 * <p>
 * create by qiulisun on 2020/11/18.<br>
 *
 * @author 51050
 */
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 找出中序遍历中与根节点对应的节点
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左闭右开
                TreeNode left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i),
                        Arrays.copyOfRange(in, 0, i - 1));
                TreeNode right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
                root.setLeft(left);
                root.setRight(right);
            }
        }
        return root;
    }
}
