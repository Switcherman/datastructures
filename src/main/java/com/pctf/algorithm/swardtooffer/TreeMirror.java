package com.pctf.algorithm.swardtooffer;

import java.time.temporal.Temporal;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *  思路: 后序遍历
 */
public class TreeMirror {

    public void mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        mirror(root.left);
        mirror(root.right);
        swapChild(root);
    }

    public void swapChild(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
