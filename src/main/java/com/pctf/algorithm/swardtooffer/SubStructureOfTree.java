package com.pctf.algorithm.swardtooffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路: 遍历两棵树,比较每个节点是否相等,不相等则递归遍历左右子树.如果root2遍历完,root1没有遍历完,则root2是root1的子树
 */
public class SubStructureOfTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {

            boolean result = false;
            if (root1 != null && root2 != null) {
                if (root1.val == root2.val) {
                    result = isSameTree(root1, root2);
                }
                if (!result) {
                    result = HasSubtree(root1.left, root2);
                }
                if (!result) {
                    result = HasSubtree(root1.right, root2);
                }
            }
            return result;

        }
    }


    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean result3 = root1.val == root2.val;
        boolean result1 = isSameTree(root1.left, root2.left);
        boolean result2 = isSameTree(root1.right, root2.right);
        return result3 && result1 && result2;
    }

}
