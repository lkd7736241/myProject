package com.sun.数据结构与算法.剑指offer;

import com.sun.vo.ListNode;

import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * create by qiulisun on 2021/3/5.<br>
 *
 * @author 51050
 */
public class 两个链表的第一个公共节点 {
    /**
     * 使用HashMap
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (pHead1 != null) {
            map.put(pHead1, pHead1.getVal());
            pHead1 = pHead1.getNext();
        }
        while (pHead2 != null) {
            if (map.containsKey(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.getNext();
        }
        return null;
    }

    /**
     * 看下面的链表例子：
     * 0-1-2-3-4-5-null
     * a-b-4-5-null
     * 代码的ifelse语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
     * 如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
     * p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
     * p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
     * 因此，两个指针所要遍历的链表就长度一样了！
     * 如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while (node1 != node2) {
            node1 = node1.getNext();
            node2 = node2.getNext();
            if (node1 != node2) {
                if (node1 == null) {
                    node1 = pHead2;
                }
                if (node2 == null) {
                    node2 = pHead1;
                }
            }
        }
        return node1;
    }
}
