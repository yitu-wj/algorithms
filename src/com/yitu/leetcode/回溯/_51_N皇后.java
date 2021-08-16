package com.yitu.leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class _51_N皇后 {
    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new LinkedList<>();
        cols=new int[n];
        place(0,result);
        return result;
    }

    /**
     * 从第row行开始摆放皇后
     */
    void place(int row,List<List<String>> result){
        if (row == cols.length) {
            show(result);
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1,result);
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
    void show(List<List<String>> result) {
        List<String> list=new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder rowStr= new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    rowStr.append("Q");
                } else {
                    rowStr.append(".");
                }
            }
            list.add(rowStr.toString());
        }
        result.add(list);
    }

    public static void main(String[] args) {
        List<List<String>> result = new _51_N皇后().solveNQueens(4);
        System.out.println(result);
    }
}
