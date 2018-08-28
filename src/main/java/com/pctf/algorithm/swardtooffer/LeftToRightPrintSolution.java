package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class LeftToRightPrintSolution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(pRoot);
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                queue.forEach(treeNode -> list.add(treeNode.val));
                result.add(new ArrayList<>(list));
                list.clear();
                queue.add(null);
                continue;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

        return result;
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
