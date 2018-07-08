package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * 思路: 中序遍历平衡树,添加到List中,list便是排序后的树.
 *      也可以直接以链表的形式输出.
 */
public class LeastKValueOfAVLTree {


    public class Solution {
        TreeNode KthNode(TreeNode pRoot, int k) {
            if(pRoot == null || k <= 0) {
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            avlTreeToList(pRoot, list);
            if(k > list.size()){
                return null;
            } else {
                return list.get(k - 1);
            }
        }

        void avlTreeToList(TreeNode node, List<TreeNode> list){
            if (node != null) {
                avlTreeToList(node.left, list);
                list.add(node);
                avlTreeToList(node.right, list);
            }
        }

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
