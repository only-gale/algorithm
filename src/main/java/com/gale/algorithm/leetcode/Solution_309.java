package com.gale.algorithm.leetcode;

/**
 * <p>给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。</p>
 * <p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:</p>
 * <ul>
 *     <li>卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。</li>
 * </ul>
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: prices = [1]
 * 输出: 0
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= prices.length <= 5000</li>
 *     <li>0 <= prices[i] <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/">最佳买卖股票时机含冷冻期</a>
 * @since 2023/2/15 17:52
 */
public class Solution_309 {
    public int maxProfit(int[] prices) {
        // soldProfit：今天卖出后的利润
        // boughtProfit：今天买入后的利润
        // preSoldProfit：前天卖出后的利润
        int l = prices.length, soldProfit, boughtProfit, preSoldProfit, tmp;
        if (l < 2) {
            return 0;
        }
        soldProfit = preSoldProfit = 0;
        boughtProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            tmp = soldProfit;
            soldProfit = Math.max(soldProfit, boughtProfit + price);
            boughtProfit = Math.max(boughtProfit, preSoldProfit - price);
            preSoldProfit = tmp;
        }
        return soldProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        Solution_309 solution309 = new Solution_309();
        System.out.println(solution309.maxProfit(prices));
    }
}
