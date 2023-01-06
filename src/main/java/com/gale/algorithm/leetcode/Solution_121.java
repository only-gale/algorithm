package com.gale.algorithm.leetcode;

/**
 * <p>给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。</p>
 * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。</p>
 * <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：[7,1,5,3,6,4]
 *     输出：5
 *     解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：prices = [7,6,4,3,1]
 *     输出：0
 *     解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">买卖股票的最佳时机</a>
 * @since 2023/1/6 10:46
 */
public class Solution_121 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfitForce(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int l = prices.length, max = 0;

        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitForce(prices));
    }
}
