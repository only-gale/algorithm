package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。</p>
 * <p>题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。</p>
 * <p>请不要使用除法，且在 O(n) 时间复杂度内完成此题。</p>
 * <br>
 * <p>示例 1:</p>
 * <pre>
 *     输入: nums = [1,2,3,4]
 *     输出: [24,12,8,6]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: nums = [-1,1,0,-3,3]
 *     输出: [0,0,9,0,0]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>2 <= nums.length <= 10^5</li>
 *     <li>-30 <= nums[i] <= 30</li>
 *     <li>保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/product-of-array-except-self/">除自身以外数组的乘积</a>
 * @since 2023/1/29 11:30
 */
public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, zeros = 0;
        int[] answer = new int[n];
        // 如果有至少2个0，则所有结果乘积均为0
        for (int num : nums) {
            if (num == 0 && ++zeros >= 2) {
                Arrays.fill(answer, 0);
                return answer;
            }
        }
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        Solution_238 solution238 = new Solution_238();
        System.out.println(Arrays.toString(solution238.productExceptSelf(nums)));
    }
}
