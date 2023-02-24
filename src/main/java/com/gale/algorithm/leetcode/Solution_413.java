package com.gale.algorithm.leetcode;

/**
 * <p>如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。</p>
 * <ul>
 *     <li>例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。</li>
 * </ul>
 * <p>给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。</p>
 * <p>子数组 是数组中的一个连续序列。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：nums = [1]
 * 输出：0
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 5000</li>
 *     <li>-1000 <= nums[i] <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/arithmetic-slices/">等差数列划分</a>
 * @since 2023/2/23 10:51
 */
public class Solution_413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length, idx;
        int[] dp;
        if (l < 3) {
            return 0;
        }
        // 当前最长等差数列子数组起始位置
        idx = 0;
        // dp[i]指代以第i个元素结尾的等差数列子数组数量
        dp = new int[l];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < l; i++) {
            dp[i] = dp[i - 1];
            // 当前等差数列连续
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i]++;
            } else {    // 当前等差数列断开
                idx = i;
            }
            // 回手掏
            if (i > 2 && i - 2 >= idx + 1) {
                int[] dp1 = new int[i - 2];
                for (int j = i - 2; j >= idx + 1; j--) {
                    if (j < dp1.length) {
                        dp1[j - 1] = dp1[j];
                    }
                    if (nums[j] - nums[j + 1] == nums[j + 1] - nums[j + 2]) {
                        dp1[j - 1]++;
                    }
                }
                dp[i] += dp1[0];
            }
        }
        return dp[l - 1];
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,5,7,9};
        int[] nums = {1,2,3,8,9,10};
        Solution_413 solution413 = new Solution_413();
        System.out.println(solution413.numberOfArithmeticSlices(nums));
    }
}
