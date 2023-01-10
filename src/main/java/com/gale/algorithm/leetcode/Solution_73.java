package com.gale.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。</p>
 *
 *
 * @see <a href="https://leetcode.cn/problems/set-matrix-zeroes/">矩阵置零</a>
 * @since 2023/1/7 22:49
 */
public class Solution_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 记录需要置零的行
        Set<Integer> memoRows = new HashSet<>(m);
        // 记录需要置零的列
        Set<Integer> memoCols = new HashSet<>(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    memoRows.add(i);
                    memoCols.add(j);
                }
            }
        }
        for (int r : memoRows) {
            setRowZeroes(matrix, r, n);
        }
        for (int c : memoCols) {
            setColZeroes(matrix, c, m);
        }
    }


    public void setRowZeroes(int[][] matrix, int row, int cols) {
        for (int i = 0; i < cols; i++) {
            matrix[row][i] = 0;
        }
    }

    public void setColZeroes(int[][] matrix, int col, int rows) {
        for (int i = 0; i < rows; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        Solution_73 solution73 = new Solution_73();
        System.out.println("before:");
        Util.printBoard(matrix);
        solution73.setZeroes(matrix);
        System.out.println("\nafter:");
        Util.printBoard(matrix);
    }
}
