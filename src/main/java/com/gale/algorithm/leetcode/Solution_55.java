package com.gale.algorithm.leetcode;

/**
 * <p>给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。</p>
 * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>
 * <p>判断你是否能够到达最后一个下标。</p>
 * <br>
 *
 * <p>示例 1</p>
 * <pre>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * </pre>
 *
 * <p>示例 2</p>
 * <pre>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 3 * 10^4</li>
 *     <li>0 <= nums[i] <= 10^5</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/jump-game/">跳跃游戏</a>
 * @since 2023/1/4 10:43
 */
public class Solution_55 {
    public boolean canJump(int[] nums) {
        int[] dp;
        if (nums.length == 1) {
            return true;
        }

        dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && (nums[j] + j >= i)) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[nums.length - 1] == 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        Solution_55 solution55 = new Solution_55();
        System.out.println(solution55.canJump(nums));
    }
}
