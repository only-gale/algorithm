package com.gale.algorithm.leetcode;

/**
 * <p>给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。</p>
 * <p>你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。</p>
 *
 * <p>示例 1：</p>
 * <img src="docFile/48_1.jpg">
 * <pre>
 *     输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *     输出：[[7,4,1],[8,5,2],[9,6,3]]
 * </pre>
 *
 * <p>示例 2：</p>
 * <img src="docFile/48_2.jpg">
 * <pre>
 *     输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 *     输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>n == matrix.length == matrix[i].length</li>
 *     <li>1 <= n <= 20</li>
 *     <li>-1000 <= matrix[i][j] <= 1000</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/rotate-image/">旋转图像</a>
 * @since 2023/1/19 16:41
 */
public class Solution_48 {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length, c = 0, steps, circles = n >> 1, i, j, y;
        // 从外圈向内圈，每圈旋转90度
        while (c <= circles) {
            // 每圈的起点
            i = j = c;
            // 每圈旋转90度的步长
            steps = n - 1 - (c << 1);

            // 每圈要旋转的元素
            for (int k = 0; k < steps; k++) {
                int i1 = i, j1 = j + k, target = matrix[i1][j1], origin;
                for (int l = 0; l < 4; l++) {
                    y = n - 1 - i1;
                    origin = matrix[j1][y];
                    matrix[j1][y] = target;
                    target = origin;
                    System.out.printf("swap [%d][%d] to [%d][%d], tmp = %d\n", i1, j1, j1, y, origin);
                    i1 = j1;
                    j1 = y;
                }
                System.out.printf("next element: [%d][%d]\n", i, j);
            }
            System.out.printf("circle %d finished\n", c);
            c++;
            Util.printBoard(matrix);
        }
    }

    public void rotate1(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        int times = 0;
        while(times <= (nums >> 1)){
            int len = nums - (times << 1);
            for(int i = 0; i < len - 1; ++i){
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] nums = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        Solution_48 solution48 = new Solution_48();
        solution48.rotate(nums);
        Util.printBoard(nums);
    }
}
