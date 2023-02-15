package com.gale.algorithm.leetcode;

/**
 * <p>给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。</p>
 * <p>环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。</p>
 * <p>子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j 其中k1 % n == k2 % n。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>n == nums.length</li>
 *     <li>1 <= n <= 3 * 10^4</li>
 *     <li>-3 * 10^4 <= nums[i] <= 3 * 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/maximum-sum-circular-subarray/">环形子数组的最大和</a>
 * @since 2023/2/13 16:55
 */
public class Solution_918 {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int n : nums) {
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(curMax, maxSum);
            curMin = Math.min(curMin + n, n);
            minSum = Math.min(curMin, minSum);
            total += n;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        Solution_918 solution918 = new Solution_918();
        System.out.println(solution918.maxSubarraySumCircular(nums));
    }
}
