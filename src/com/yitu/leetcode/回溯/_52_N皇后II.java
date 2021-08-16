package com.yitu.leetcode.回溯;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class _52_N皇后II {
    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;
    /**
     * 一共有多少种摆法
     */
    int ways;

    public int totalNQueens(int n) {
        cols = new int[n];
        place(0);
        return ways;
    }
    /**
     * 从第row行开始摆放皇后
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            ways++;
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                return false;
            }
            // 第i行的皇后跟第row行第col列格子处在同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int total = new _52_N皇后II().totalNQueens(8);
        System.out.println(total);
    }
}
