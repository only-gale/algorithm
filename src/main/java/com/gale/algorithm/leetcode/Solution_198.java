package com.gale.algorithm.leetcode;

/**
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。</p>
 * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 100</li>
 *     <li>0 <= nums[i] <= 400</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/house-robber/">打家劫舍</a>
 * @since 2023/2/10 09:50
 */
public class Solution_198 {
    public int rob(int[] nums) {
        int[] dp;
        int len;
        if ((len = nums.length) == 1) {
            return nums[0];
        }
        dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Solution_198 solution198 = new Solution_198();
        System.out.println(solution198.rob(nums));
    }
}
