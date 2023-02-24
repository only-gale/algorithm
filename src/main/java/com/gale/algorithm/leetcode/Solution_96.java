package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/96_1.jpeg" />
 * <pre>
 * 输入：n = 3
 * 输出：5
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：n = 1
 * 输出：1
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= n <= 19</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/unique-binary-search-trees/">不同的二叉搜索树</a>
 * @since 2023/2/24 16:26
 */
public class Solution_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        Solution_96 solution96 = new Solution_96();
        System.out.println(solution96.numTrees(n));
    }
}
