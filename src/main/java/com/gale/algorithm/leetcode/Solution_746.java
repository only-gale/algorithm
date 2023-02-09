package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。</p>
 * <p>你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。</p>
 * <p>请你计算并返回达到楼梯顶部的最低花费。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>2 <= cost.length <= 1000</li>
 *     <li>0 <= cost[i] <= 999</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/">使用最小花费爬楼梯</a>
 * @since 2023/2/9 11:43
 */
public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
//        int[] cost = {10,15,20};
        Solution_746 solution746 = new Solution_746();
        System.out.println(solution746.minCostClimbingStairs(cost));
    }
}
