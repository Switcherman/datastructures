package com.pctf.leetcode;

/**
 * 79
 *
 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true.
 给定 word = "SEE", 返回 true.
 给定 word = "ABCB", 返回 false.

 */
public class ExistSolution {
    public boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) {
            return true;
        }
        if (board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] flag = new boolean[board.length][board[0].length];
                if (exist(i, j, board, word.toCharArray(), 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int i, int j, char[][] board, char[] word, int index, boolean[][] flag) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word[index] || flag[i][j]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        flag[i][j] = true;
        boolean res =  exist(i + 1, j, board, word, index + 1, flag)
                || exist(i - 1, j, board, word, index + 1, flag)
                || exist(i, j + 1, board, word, index + 1, flag)
                || exist(i, j - 1, board, word, index + 1, flag);
        flag[i][j] = false;
        return res;
    }
}
