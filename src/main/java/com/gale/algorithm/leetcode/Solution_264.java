package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数 n ，请你找出并返回第 n 个 丑数 。</p>
 * <p>丑数 就是只包含质因数 2、3 和/或 5 的正整数。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= n <= 1690</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/ugly-number-ii/">丑数 II</a>
 * @since 2023/2/24 15:19
 */
public class Solution_264 {
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1, num2, num3, num5, min;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            num2 = dp[p2] << 1;
            num3 = dp[p3] * 3;
            num5 = dp[p5] * 5;
            min = Math.min(Math.min(num2, num3), num5);
            dp[i] = min;
            if (min == num2) {
                p2++;
            }
            if (min == num3) {
                p3++;
            }
            if (min == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        Solution_264 solution264 = new Solution_264();
        System.out.println(solution264.nthUglyNumber(n));
    }
}
