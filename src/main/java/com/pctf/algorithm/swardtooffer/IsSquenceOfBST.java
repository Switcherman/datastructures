package com.pctf.algorithm.swardtooffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路: BST的后序遍历,最后一个结果是根,剩下的分为两部分,前半部分是左子树,所有结果小于根
 * 后半部分是右子树,所有结果大于根.左右子树也分别满足条件.递归
 */
public class IsSquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence){
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        if(sequence.length == 1) {
            return true;
        }
        return verifyChild(0, sequence.length - 1, sequence);
    }

    private boolean verifyChild(int start, int root, int[] sequence) {
        if(start >= root) {
            return true;
        }
        int i = root - 1;
        while (i > start && sequence[root] < sequence[i]) { // 找到右子树的起点
            i--;
        }
        for (int j = start; j < i; j++) {
            if(sequence[j] > sequence[root]) {
                return false;
            }
        }
        return verifyChild(start, i, sequence) && verifyChild(i + 1, root, sequence);
    }
}
