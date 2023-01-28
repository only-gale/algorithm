package com.gale.algorithm.leetcode;

/**
 * <p>给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。</p>
 * <br>
 * <p>示例 1：</p>
 * <img src="docFile/59_1.jpg">
 * <pre>
 *     输入：n = 3
 *     输出：[[1,2,3],[8,9,4],[7,6,5]]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：n = 1
 *     输出：[[1]]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= n <= 20</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/spiral-matrix-ii/">螺旋矩阵 II</a>
 * @since 2023/1/19 16:54
 */
public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int circles = n >> 1, c = 0, i, j, e = 1, steps;
        int[][] matrix = new int[n][n];
        while (c <= circles) {
            i = j = c;
            steps = n - 1 - (c << 1);
            boolean locki = false, lockj = false;
            while (steps >= 0) {
                matrix[i][j] = e++;
                if (!lockj && j < c + steps) {
                    j++;
                } else if (!locki && i < c + steps) {
                    i++;
                } else if (j > c) {
                    j--;
                    lockj = true;
                } else if (i > c){
                    i--;
                    locki = true;
                }
                if (i == c && j == c) {
                    break;
                }
            }
            c++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        Solution_59 solution59 = new Solution_59();
        Util.printBoard(solution59.generateMatrix(n));
    }
}
