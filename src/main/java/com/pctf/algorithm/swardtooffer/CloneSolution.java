package com.pctf.algorithm.swardtooffer;



/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 * 思路:
 * 1.复制原链表,每个节点的下一个节点复制为一个新节点
 * 2.复制兄弟节点的关系
 * 3.拆分链表.
 */
public class CloneSolution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode current = pHead;
        while(current != null) {
            RandomListNode cloneNode = new RandomListNode(current.label);
            RandomListNode nextNode = current.next;
            current.next = cloneNode;
            cloneNode.next = nextNode;
            current = current.next.next;
        }
        // 复制兄弟节点对应关系
        current = pHead;
        while (current != null) {
            RandomListNode clone = current.next;
            clone.random = current.random == null ? null : current.random.next;
            current = clone.next;
        }
        // 拆出两个链表
        current = pHead;
        RandomListNode cloneNode = pHead.next;
        while (current != null) {
            RandomListNode clone = current.next;
            current.next = clone.next;
            clone.next = current.next == null ? null : current.next.next;
            current = current.next;
        }
        return cloneNode;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
