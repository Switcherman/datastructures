package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 存在O(n)解法,待优化
 * 思路: 双路遍历链表,找到相遇节点.
 * 一个节点从头遍历,另一个节点继续遍历,相遇的节点即为结果
 */
public class EntryNodeOfLoopSolution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while(fast != slow) {
            if(fast.next.next != null && slow.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
