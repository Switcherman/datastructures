package com.pctf.algorithm.swardtooffer;

/**
 * 两个链表的第一个公共节点
 *
 * 思路: 遍历两个链表
 */
public class FindFirstSameNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        while (pHead1 != null) {
            if(isListNode(pHead1, pHead2)) {
                return pHead1;
            } else {
                pHead1 = pHead1.next;
            }
        }
        return null;
    }

    private boolean isListNode(ListNode node1, ListNode pHead) {
         while (pHead != null) {
             if(node1 == pHead) {
                 return true;
             } else {
                 pHead = pHead.next;
             }
         }
         return false;
    }

}
