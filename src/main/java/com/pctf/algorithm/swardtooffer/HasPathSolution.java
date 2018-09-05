package com.pctf.algorithm.swardtooffer;

/**
 *
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPathSolution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null) {
            return false;
        }
        if (str == null) {
            return true;
        }
        for (int i = 0; i < matrix.length; i++) {
            int x = i / cols;
            int y = i % cols;
            boolean[] mark = new boolean[matrix.length];
            if (hasNextPath(x, y, mark, str, 0, cols, rows, matrix)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNextPath(int x, int y, boolean[] mark, char[] str, int i, int cols, int rows, char[] matrix) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || mark[x * cols + y] || str[i] != matrix[x * cols + y]) {
            return false;
        }

        if (i == str.length - 1) {
            return true;
        }
        mark[x * cols + y] = true;
        return hasNextPath(x - 1, y, mark, str, i + 1, cols, rows, matrix)
            || hasNextPath(x + 1, y, mark, str, i + 1, cols, rows, matrix)
            || hasNextPath(x, y - 1, mark, str, i + 1, cols, rows, matrix)
            || hasNextPath(x, y + 1, mark, str, i + 1, cols, rows, matrix);
    }
}
