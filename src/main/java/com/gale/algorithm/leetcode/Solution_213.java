package com.gale.algorithm.leetcode;

/**
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。</p>
 * <p>这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。</p>
 * <p>同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。</p>
 * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：nums = [1,2,3]
 * 输出：3
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 100</li>
 *     <li>0 <= nums[i] <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/house-robber-ii/">...</a>
 * @since 2023/2/10 10:11
 */
public class Solution_213 {
    public int rob(int[] nums) {
        int[] dp;
        int len, max;
        if ((len = nums.length) == 1) {
            return nums[0];
        }
        dp = new int[len];

        // 计算0 - (len - 2)索引区间的最大解
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        max = dp[len - 1];
        // 计算1 - (len - 1)索引区间的最大解
        dp[1] = len > 2 ? nums[1] : Math.max(dp[1], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(max, dp[len - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        Solution_213 solution213 = new Solution_213();
        System.out.println(solution213.rob(nums));
    }
}
