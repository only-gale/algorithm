package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。</p>
 * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</p>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入: numRows = 5
 *     输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: numRows = 1
 *     输出: [[1]]
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/reshape-the-matrix/">重塑矩阵</a>
 * @since 2023/1/7 22:19
 */
public class Solution_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        List<Integer> lastRow = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            renderRow(row, i, lastRow);
            ans.add(new ArrayList<>(row));
            lastRow = row;
        }
        return ans;
    }

    private static void renderRow(List<Integer> row, int rowLen, List<Integer> lastRow) {
        for (int i = 0; i < rowLen; i++) {
            row.add(i, (i == 0 || i == rowLen - 1) ? 1 : (lastRow.get(i - 1) + lastRow.get(i)));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = generate(5);
        System.out.println(ans);
    }
}
