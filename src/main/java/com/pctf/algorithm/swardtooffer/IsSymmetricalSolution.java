package com.pctf.algorithm.swardtooffer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 *
 * 思路: 递归比较左右子树
 */
public class IsSymmetricalSolution {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return false;
        }
        return isMirrorTree(pRoot.left, pRoot.right);
    }

    private boolean isMirrorTree(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        } else if(tree1 == null || tree2 == null) {
            return false;
        }
        return tree1.val == tree2.val && isMirrorTree(tree1.left, tree2.right) && isMirrorTree(tree1.right, tree2.left);
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
