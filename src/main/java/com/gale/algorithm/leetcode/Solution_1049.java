package com.gale.algorithm.leetcode;

/**
 * <p>有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。</p>
 * <p>每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。</p>
 * <p>那么粉碎的可能结果如下：</p>
 * <ul>
 *     <li>如果 x == y，那么两块石头都会被完全粉碎；</li>
 *     <li>如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。</li>
 * </ul>
 * <p>最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。</p>
 * @see <a href="https://leetcode.cn/problems/last-stone-weight-ii/">最后一块石头的重量II</a>
 */
public class Solution_1049 {
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone :
                stones) {
            sum += stone;
        }
        int maxCapacity = sum / 2;
        int[] dp = new int[maxCapacity + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = maxCapacity; j >= i; j--) {
                if (j - stones[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - dp[maxCapacity] - dp[maxCapacity];
    }

    public static void main(String[] args) {
//        int[] stones = new int[]{2,7,4,1,8,1};
        int[] stones = new int[]{31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }
}
