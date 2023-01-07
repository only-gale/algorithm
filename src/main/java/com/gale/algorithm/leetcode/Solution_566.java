package com.gale.algorithm.leetcode;

/**
 * <p>在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。</p>
 * <p>给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。</p>
 * <p>重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。</p>
 * <p>如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。</p>
 *
 *
 * @see <a href="https://leetcode.cn/problems/reshape-the-matrix/">重塑矩阵</a>
 * @since 2023/1/7 21:25
 */
public class Solution_566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int t;
        if ((t = r * c) <= 0) {
            return mat;
        }

        int m = mat.length, n = mat[0].length;
        if (m * n != t) {
            return mat;
        }

        int[][] ans = new int[r][c];

        for (int i = 0; i < t; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        return ans;
    }

    public static void printBoard(int[][] board) {
        for (int[] line : board) {
            for (int i = 0; i < line.length; i++) {
                int s = line[i];
                if (i == (line.length - 1)) {
                    System.out.print(s);
                } else {
                    System.out.printf("%d ", s);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        System.out.println("origin: ");
        printBoard(mat);
        int r = 1, c = 4;
        int[][] ans = matrixReshape(mat, r, c);
        System.out.println("\nafter: ");
        printBoard(ans);
    }
}
