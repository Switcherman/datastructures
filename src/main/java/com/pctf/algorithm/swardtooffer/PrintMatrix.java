package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int row = matrix.length;
        if (row == 0)
            return al;
        int col = matrix[0].length;
        int circle = ((row > col ? col : row) + 1) / 2;
        for (int i = 0; i < circle; i++) {
            for (int j = i; j < col - i; j++)
                al.add(matrix[i][j]);

            for (int j = i + 1; j < row - i; j++)
                al.add(matrix[j][col - i - 1]);

            for (int j = col - i - 2; j >= i && row - i - 1 != i; j--)
                al.add(matrix[row - i - 1][j]);

            for (int j = row - i - 2; j > i && col - i - 1 != i; j--)
                al.add(matrix[j][i]);
        }
        return al;
    }
}
