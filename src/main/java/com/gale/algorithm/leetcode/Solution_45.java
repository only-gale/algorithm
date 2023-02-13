package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。</p>
 * <p>每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:</p>
 * <ul>
 *     <li>0 <= j <= nums[i] </li>
 *     <li>i + j < n</li>
 * </ul>
 * <p>返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>1 <= nums.length <= 104</li>
 *     <li>0 <= nums[i] <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/jump-game-ii/">跳跃游戏 II</a>
 * @since 2023/2/13 09:36
 */
public class Solution_45 {
    public int jump(int[] nums) {
        int l = nums.length;
        // 到达第i个台阶最少需要的步数
        int[] dp;
        if (l == 1) {
            return 0;
        }
        dp = new int[l];
        // 默认到不了
        Arrays.fill(dp, l + 1);
        // 因为初始在第一个台阶，即num[0]，则dp[0]=0
        dp[0] = 0;
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[l - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution_45 solution45 = new Solution_45();
        System.out.println(solution45.jump(nums));
    }
}
