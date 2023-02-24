package com.gale.algorithm.leetcode;

/**
 * <p>给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。</p>
 * <p>你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。</p>
 * <p>返回获得利润的最大值。</p>
 * <p>注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= prices.length <= 5 * 10^4</li>
 *     <li>1 <= prices[i] < 5 * 10^4</li>
 *     <li>0 <= fee < 5 * 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">买卖股票的最佳时机含手续费</a>
 * @since 2023/2/20 10:13
 */
public class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        // soldProfit：今天卖出后的利润
        // boughtProfit：今天买入后的利润
        int l = prices.length, soldProfit, boughtProfit;
        if (l < 2) {
            return 0;
        }
        soldProfit = 0;
        boughtProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            soldProfit = Math.max(soldProfit, boughtProfit + price);
            boughtProfit = Math.max(boughtProfit, soldProfit - price - fee);
        }
        return soldProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        Solution_714 solution714 = new Solution_714();
        System.out.println(solution714.maxProfit(prices, fee));
    }
}
