package com.pctf.algorithm.swardtooffer;

/**
 * 判断一个二叉树是否是平衡二叉树
 * 思路1:遍历左右子树,深度差绝对值<=1 ,递归执行
 * 思路2:遍历左右子树,深度差大于1 直接返回.
 */
public class IsBalanced_SolutionSolution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return getDepth(root) != -1;
        // return Math.abs(height(root.right) - height(root.left)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        if(left == -1) {
            return -1;
        }
        int right = getDepth(node.right);
        if(right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
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
