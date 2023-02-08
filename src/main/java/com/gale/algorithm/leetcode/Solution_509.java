package com.gale.algorithm.leetcode;

/**
 * <p>斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。</p>
 * <p>也就是：</p>
 * <pre>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * </pre>
 * <p>给定 n ，请计算 F(n) 。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>0 <= n <= 30</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/fibonacci-number/">斐波那契数</a>
 * @since 2023/2/8 13:42
 */
public class Solution_509 {
    public int fib(int n) {
        int[] dp;
        if (n < 2) {
            return n;
        }
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        Solution_509 solution509 = new Solution_509();
        System.out.println(solution509.fib(n));
    }
}
