package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。</p>
 * <p>测试用例的答案是一个 32-位 整数。</p>
 * <p>子数组 是数组的连续子序列。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>1 <= nums.length <= 2 * 10^4</li>
 *     <li>-10 <= nums[i] <= 10</li>
 *     <li>nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/maximum-product-subarray/">乘积最大子数组</a>
 * @since 2023/2/14 09:34
 */
public class Solution_152 {
    public int maxProduct(int[] nums) {
        // pre 指代前缀乘积
        // preP 指代最大前缀乘积
        // preN 指代最小前缀乘积
        int l = nums.length, max = Integer.MIN_VALUE, preP = 1, preN = 1, tmp;
        if (l == 1) {
            return nums[0];
        }
        for (int num : nums) {
            if (num < 0) {
                tmp = preP;
                preP = preN;
                preN = tmp;
            }
            preP = Math.max(preP * num, num);
            preN = Math.min(preN * num, num);
            max = Math.max(max, preP);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,-5,-2,-4,-3};
        Solution_152 solution152 = new Solution_152();
        System.out.println(solution152.maxProduct(nums));
    }
}
