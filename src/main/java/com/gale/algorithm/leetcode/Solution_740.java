package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 nums ，你可以对它进行一些操作。</p>
 * <p>每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。</p>
 * <p>开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 2 * 10^4</li>
 *     <li>1 <= nums[i] <= 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/delete-and-earn/">删除并获得点数</a>
 * @since 2023/2/10 11:21
 */
public class Solution_740 {
    public int deleteAndEarn(int[] nums) {
        int[] idx, dp;
        int len, max = 0;
        if ((len = nums.length) == 1) {
            return nums[0];
        }
        // idx保存nums中以值为索引，以个数为值的记录
        for (int n : nums) {
            max = Math.max(max, n);
        }
        idx = new int[max + 1];
        for (int i = 0; i < len; i++) {
            idx[nums[i]] += 1;
        }
        dp = new int[max + 2];
        dp[0] = 0;
        dp[1] = idx[0];
        for (int i = 2; i <= max + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + (i - 1) * idx[i - 1], dp[i - 1]);
        }
        return dp[max + 1];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        Solution_740 solution740 = new Solution_740();
        System.out.println(solution740.deleteAndEarn(nums));
    }
}
