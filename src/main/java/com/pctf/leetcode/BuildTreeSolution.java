package com.pctf.leetcode;

import com.pctf.TreeNode;

import java.util.Stack;

public class BuildTreeSolution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postorder.length; i++) {
            stack.push(postorder[i]);
        }
        return helper(stack, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(Stack<Integer> stack, int[] inorder, int start, int end) {
        if (start > end || stack.size() == 0) {
            return null;
        }
        int top = stack.pop();
        int index = start;
        for (int i = 0; i <= end; i++ ){
            if (inorder[i] == top) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(top);
        root.right = helper(stack, inorder, index + 1, end);
        root.left = helper(stack, inorder, start, index - 1);
        return root;
    }

}
