package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。</p>
 * <p>在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。</p>
 * <p>返回 你能获得的 最大 利润 。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *     总利润为 4 。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= prices.length <= 3 * 10^4</li>
 *     <li>0 <= prices[i] <= 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">买卖股票的最佳时机 II</a>
 * @since 2023/2/15 16:43
 */
public class Solution_122 {
    public int maxProfit(int[] prices) {
        int len = prices.length, minPrices = Integer.MAX_VALUE, profit = 0;
        if (len < 2) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            } else if (prices[i] > minPrices) {
                // 一路升高
                if (i + 1 < len && prices[i + 1] > prices[i]) {
                    continue;
                }
                profit += prices[i] - minPrices;
                minPrices = Integer.MAX_VALUE;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution_122 solution122 = new Solution_122();
        System.out.println(solution122.maxProfit(prices));
    }
}
