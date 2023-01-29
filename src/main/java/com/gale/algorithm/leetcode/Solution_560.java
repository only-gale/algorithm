package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums = [1,1,1], k = 2
 *     输出：2
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums = [1,2,3], k = 3
 *     输出：2
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 2 * 10^4</li>
 *     <li>-1000 <= nums[i] <= 1000</li>
 *     <li>-10^7 <= k <= 10^7</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/subarray-sum-equals-k/">和为 K 的子数组</a>
 * @since 2023/1/29 14:06
 */
public class Solution_560 {

    /**
     * <p>连续子序列定义为[j, i] = 前缀和pre[i - 1] + nums[i] - 前缀和pre[j - 1]</p>
     * <p>则满足和为k的连续子序列[j, i] = 前缀和pre[i - 1] + nums[i] - 前缀和pre[j - 1] == k</p>
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int ans = 0, pre = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (memo.containsKey(pre - k)) {
                ans += memo.get(pre - k);
            }
            memo.put(pre, memo.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    /**
     * 循环遍历和为k的以索引i结尾的连续子序列
     */
    public int subarraySum_loop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int l = 0, r = 0, sum = 0, ans = 0;
        while (l < n) {
            sum += nums[r++];
            if (sum == k) {
                ans++;
            }
            if (r >= n) {
                l++;
                r = l;
                sum = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_560 solution560 = new Solution_560();
        int[] nums = {-1,-1,1};
        int k = 0;
        System.out.println(solution560.subarraySum(nums, k));
    }
}
