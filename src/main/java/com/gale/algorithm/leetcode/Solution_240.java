package com.gale.algorithm.leetcode;

/**
 * <p>编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。</p>
 * <p>该矩阵具有以下特性：</p>
 * <ul>
 *     <li>每行的元素从左到右升序排列。</li>
 *     <li>每列的元素从上到下升序排列。</li>
 * </ul>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 *     输出：true
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 *     输出：false
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>m == matrix.length</li>
 *     <li>n == matrix[i].length</li>
 *     <li>1 <= n, m <= 300</li>
 *     <li>-10^9 <= matrix[i][j] <= 10^9</li>
 *     <li>每行的所有元素从左到右升序排列</li>
 *     <li>每列的所有元素从上到下升序排列</li>
 *     <li>-10^9 <= target <= 10^9</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/">搜索二维矩阵 II</a>
 * @since 2023/1/24 13:30
 */
public class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, mid;
        int[] tmp = new int[m - 1];
        if (binarySearch(matrix[0], 0, n - 1, target)) {
            return true;
        }

        mid = binarySearchFirstSmaller(matrix[0], 0, n - 1, target);

        for (int i = mid; i >= 0; i--) {
            // 直接判断第一行
            if (matrix[0][mid] == target) {
                return true;
            }
            if (m > 1) {
                // mid列剩余元素进行二分查找
                col2row(matrix, i, tmp);
                if (binarySearch(tmp, 0, m - 1 - 1, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 找到第一行第一个小于等于target的列
     * @param nums   原二位数组的第一行
     * @param from   0
     * @param to     原二位数组的第一行的最后一个元素索引
     * @param target 目标值
     */
    public int binarySearchFirstSmaller(int[] nums, int from, int to, int target) {
        int mid = from + ((to - from) >> 1);

        if (nums[to] <= target) {
            return to;
        }

        if (from == mid) {
            return from;
        }

        return nums[mid] > target ? binarySearchFirstSmaller(nums, from, mid, target) : binarySearchFirstSmaller(nums, mid, to, target);
    }

    /**
     * 二分查找
     * @param nums   一维数组
     * @param from   0
     * @param to     一维数组的最后一个元素索引
     * @param target 目标值
     */
    public boolean binarySearch(int[] nums, int from, int to, int target) {
        int mid = from + ((to - from) >> 1);

        if (nums[mid] == target) {
            return true;
        }

        if (from == mid) {
            return nums[from] == target || nums[to] == target;
        }

        return nums[mid] > target ? binarySearch(nums, from, mid - 1, target) : binarySearch(nums, mid + 1, to, target);
    }

    public void col2row(int[][] matrix, int col, int[] row) {
        for (int i = 1; i < matrix.length; i++) {
            row[i - 1] = matrix[i][col];
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target = 19;
        Solution_240 solution240 = new Solution_240();
        System.out.println(solution240.searchMatrix(matrix, target));
    }
}
