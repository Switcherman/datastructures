package com.pctf.algorithm.swardtooffer;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路: 递归遍历根节点的左右子树.相当于层序遍历
 */
public class DepthOfBinaryTree {
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public class Solution {
        public int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(1 + TreeDepth(root.left), 1 + TreeDepth(root.right));
    }
    }
}
