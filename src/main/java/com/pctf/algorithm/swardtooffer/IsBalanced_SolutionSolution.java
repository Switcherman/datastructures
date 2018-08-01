package com.pctf.algorithm.swardtooffer;

/**
 * 判断一个二叉树是否是平衡二叉树
 */
public class IsBalanced_SolutionSolution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(height(root.right) - height(root.left)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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
