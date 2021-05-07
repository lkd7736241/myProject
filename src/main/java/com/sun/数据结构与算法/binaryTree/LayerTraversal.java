package com.sun.数据结构与算法.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树层遍历
 * create by qiulisun on 2018/12/17.<br>
 */
public class LayerTraversal {

    public static void main(String[] args){

        BTNode nodeF = new BTNode("F");
        BTNode nodeC = new BTNode("C");
        BTNode nodeE = new BTNode("E");
        BTNode nodeA = new BTNode("A");
        BTNode nodeD = new BTNode("D");
        BTNode nodeH = new BTNode("H");
        BTNode nodeG = new BTNode("G");
        BTNode nodeB = new BTNode("B");
        BTNode nodeM = new BTNode("M");

        nodeF.left = nodeC;
        nodeF.right = nodeE;
        nodeC.left = nodeA;
        nodeC.right = nodeD;
        nodeE.left = nodeH;
        nodeE.right = nodeG;
        nodeD.left = nodeB;
        nodeG.left = nodeM;

        doLayerTraversal(nodeF);
    }

    public static void doLayerTraversal(BTNode root) {

        if (root == null) {
        	return;
        }

        Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.add(root);

        while (queue.size() != 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BTNode temp = queue.poll();
                System.out.println(temp.data + "");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                	queue.add(temp.right);
                }
            }
        }
    }
}

class BTNode {
    public String data;
    public BTNode left;
    public BTNode right;

    public BTNode(String data) {
        this.data = data;
    }
}