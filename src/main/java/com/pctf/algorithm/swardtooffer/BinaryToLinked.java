package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路: 中序遍历,节点装进一个集合,遍历集合更改节点顺序.返回头节点
 */
public class BinaryToLinked {

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }



    public class Solution {

        private void nodeSort(TreeNode node, List<TreeNode> list) {
            if (node != null) {
                nodeSort(node.left, list);
                list.add(node);
                nodeSort(node.right, list);
            }
        }

        public TreeNode Convert(TreeNode pRootOfTree) {
            if (pRootOfTree == null) {
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            nodeSort(pRootOfTree, list);
            for (int i = 0; i < list.size() - 1; i++) {
                TreeNode node1 = list.get(i);
                TreeNode node2 = list.get(i + 1);
                node1.right = node2;
                node2.left = node1;
            }
            return list.get(0);
        }
    }

}
