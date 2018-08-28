package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路:(1) 利用链表可以双向遍历的特点.
 * (2) 树的层序遍历
 */
public class PrintSolution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(pRoot);
        boolean leftToRight = true;
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) { // 到达分隔符
                Iterator<TreeNode> iterator = null;
                if (leftToRight) {
                    iterator = queue.iterator();
                } else {
                    iterator = queue.descendingIterator();
                }
                leftToRight = !leftToRight;
                while (iterator.hasNext()) {
                    list.add(iterator.next().val);
                }
                result.add(new ArrayList<>(list));
                list.clear();
                queue.add(null); //加入分隔符
                continue;// 跳出循环
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
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
