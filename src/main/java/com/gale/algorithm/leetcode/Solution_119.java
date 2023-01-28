package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。</p>
 * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</p>
 * <br>
 * <p>示例 1:</p>
 * <pre>
 *     输入: rowIndex = 3
 *     输出: [1,3,3,1]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: rowIndex = 0
 *     输出: [1]
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 *     输入: rowIndex = 1
 *     输出: [1,1]
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>0 <= rowIndex <= 33</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/pascals-triangle-ii/">杨辉三角 II</a>
 * @since 2023/1/19 16:38
 */
public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);
        if (rowIndex == 0) {
            return row;
        }
        if (rowIndex == 1) {
            row.add(1);
            return row;
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        for (int i = 1; i < rowIndex; i++) {
            row.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        row.add(1);
        return row;
    }

    public static void main(String[] args) {
        Solution_119 solution119 = new Solution_119();
        System.out.println(solution119.getRow(6));
    }
}
