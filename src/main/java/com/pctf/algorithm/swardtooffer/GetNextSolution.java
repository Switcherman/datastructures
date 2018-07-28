package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路: 找到根节点, 中序遍历,遍历到该节点后返回中序遍历的下一个节点
 */
public class GetNextSolution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }
        List<TreeLinkNode> list = new ArrayList<>();
        printTree(root, list);
        int index = list.indexOf(pNode);
        return index == list.size() - 1 ? null : list.get(index + 1);
    }

    private void printTree(TreeLinkNode root, List<TreeLinkNode> list) {
        if(root == null) {
            return;
        }
        printTree(root.left, list);
        list.add(root);
        printTree(root.right, list);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
