package com.pctf.algorithm.swardtooffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCountSolution {

    private int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        movingCount(threshold, 0, 0, rows, cols, flag);
        return count;
    }

    private void movingCount(int threshold, int rowPos, int colPos, int rows, int cols, boolean[][] flag) {
        if (rowPos >= rows || colPos >= cols || !couldArrive(threshold, rowPos, colPos) || flag[rowPos][colPos]) {
            return;
        }
        flag[rowPos][colPos] = true;
        count++;
        movingCount(threshold, rowPos + 1, colPos, rows, cols, flag);
        movingCount(threshold, rowPos, colPos + 1, rows, cols, flag);
    }

    public boolean couldArrive(int threshold, int rows, int cols) {
        int sum = 0;
        while (rows > 0) {
            sum += rows % 10;
            rows /= 10;
        }
        while (cols > 0) {
            sum += cols % 10;
            cols /= 10;
        }
        return threshold >= sum;
    }
}
