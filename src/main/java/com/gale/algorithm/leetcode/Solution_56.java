package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *     输出：[[1,6],[8,10],[15,18]]
 *     解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：intervals = [[1,4],[4,5]]
 *     输出：[[1,5]]
 *     解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= intervals.length <= 10^4</li>
 *     <li>intervals[i].length == 2</li>
 *     <li>0 <= starti <= endi <= 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/merge-intervals/">合并区间</a>
 * @since 2023/1/19 09:44
 */
public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> merged = new ArrayList<>(intervals.length);
        int[] tmp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= tmp[1]) {
                tmp = new int[]{tmp[0], Math.max(intervals[i][1], tmp[1])};
            } else {
                merged.add(tmp);
                tmp = intervals[i];
            }
        }
        merged.add(tmp);
        int[][] ans = new int[merged.size()][2];
        merged.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        Solution_56 solution56 = new Solution_56();
        Util.printBoard(solution56.merge(intervals));
    }
}
