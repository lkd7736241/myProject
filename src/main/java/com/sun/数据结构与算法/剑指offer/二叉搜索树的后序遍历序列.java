package com.sun.数据结构与算法.剑指offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 示例
 * 输入：[4,8,6,12,16,14,10]
 * 输出：true
 * create by qiulisun on 2021/3/8.<br>
 *
 * @author 51050
 */
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        int[] array = {7, 4, 6, 5};
        boolean b = VerifySquenceOfBST(array);
    }

    public static boolean helpVerify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 判断左右子树的分割点
        int i;
        for (i = start; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        // 检查右边是否有比最后一个节点小的节点
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        // 递归判断左右子树是否符合要求
        return helpVerify(sequence, start, i - 1) && helpVerify(sequence, i, end - 1);
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return helpVerify(sequence, 0, sequence.length - 1);
    }
}
