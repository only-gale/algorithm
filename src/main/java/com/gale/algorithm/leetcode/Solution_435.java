package com.gale.algorithm.leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。</p>
 * <br>
 * <p>示例 1:</p>
 * <pre>
 *     输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 *     输出: 1
 *     解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: intervals = [ [1,2], [1,2], [1,2] ]
 *     输出: 2
 *     解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 *     输入: intervals = [ [1,2], [2,3] ]
 *     输出: 0
 *     解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>1 <= intervals.length <= 10^5</li>
 *     <li>intervals[i].length == 2</li>
 *     <li>-5 * 10^4 <= starti < endi <= 5 * 10^4</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/non-overlapping-intervals/">无重叠区间</a>
 * @since 2023/1/28 10:32
 */
public class Solution_435 {

    /**
     * 贪心算法解法：以区间结束时间从小到大排序
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int end = intervals[0][1], ans = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                ans++;
                end = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }

    /**
     * 动态规划解法：以区间开始时间从小到大排序
     */
    public int eraseOverlapIntervals_dp(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return intervals.length - Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,2}, {1,3}, {2,4}, {3,5}, {4,6}};
        Solution_435 solution435 = new Solution_435();
        System.out.println(solution435.eraseOverlapIntervals(intervals));
    }
}
