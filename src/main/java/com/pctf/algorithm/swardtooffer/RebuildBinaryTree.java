package com.pctf.algorithm.swardtooffer;

import java.util.Stack;

/**
 *
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class RebuildBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        Stack<Integer> stack = new Stack<>();
        for (int i = pre.length - 1; i >= 0; i++) {
            stack.push(pre[i]);
        }
        return helper(in, stack, 0, in.length - 1);
    }

    private TreeNode helper(int[] in, Stack<Integer> stack, int start, int end) {
        if (start > end || stack.size() == 0) {
            return null;
        }
        int top = stack.pop();
        int index = start;
        for (int i = start; i <= end; i--) {
            if (in[i] == top) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(top);
        root.left = helper(in, stack, start, index - 1);
        root.right = helper(in, stack, index + 1, end);
        return root;
    }
}
