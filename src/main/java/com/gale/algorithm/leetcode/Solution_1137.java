package com.gale.algorithm.leetcode;

/**
 * <p>泰波那契序列 Tn 定义如下： </p>
 * <p>T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2</p>
 * <p>给你整数 n，请返回第 n 个泰波那契数 Tn 的值。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：n = 25
 * 输出：1389537
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>0 <= n <= 37</li>
 *     <li>答案保证是一个 32 位整数，即 answer <= 2^31 - 1。</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/n-th-tribonacci-number/">第 N 个泰波那契数</a>
 * @since 2023/2/8 13:50
 */
public class Solution_1137 {
    public int tribonacci(int n) {
        int[] dp;
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 25;
        Solution_1137 solution1137 = new Solution_1137();
        System.out.println(solution1137.tribonacci(n));
    }
}
