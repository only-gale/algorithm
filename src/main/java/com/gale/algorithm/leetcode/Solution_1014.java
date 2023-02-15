package com.gale.algorithm.leetcode;

/**
 * <p>给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。</p>
 * <p>一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。</p>
 * <p>返回一对观光景点能取得的最高分。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：values = [1,2]
 * 输出：2
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>2 <= values.length <= 5 * 10^4</li>
 *     <li>1 <= values[i] <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/best-sightseeing-pair/">最佳观光组合</a>
 * @since 2023/2/15 14:15
 */
public class Solution_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length, max = 0;
        // dp[i] = [i + 1, len - 1]的最大值
        int[] dp = new int[len];
        dp[len - 1] = values[len - 1] - len + 1;
        for (int i = len - 2; i > 0; i--) {
            dp[i] = Math.max(values[i] - i, dp[i + 1]);
        }
        for (int i = 1; i < len; i++) {
            max = Math.max(values[i - 1] + i - 1 + dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
//        int[] values = {1,1,1};
        Solution_1014 solution1014 = new Solution_1014();
        System.out.println(solution1014.maxScoreSightseeingPair(values));
    }
}
