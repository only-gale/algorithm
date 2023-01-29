package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。</p>
 * <p>如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。</p>
 * <br>
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums = [1,2,3,4,5]
 *     输出：true
 *     解释：任何 i < j < k 的三元组都满足题意
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums = [5,4,3,2,1]
 *     输出：false
 *     解释：不存在满足题意的三元组
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：nums = [2,1,5,0,4,6]
 *     输出：true
 *     解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 5 * 10^5</li>
 *     <li>-2^31 <= nums[i] <= 2^31 - 1</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/increasing-triplet-subsequence/">递增的三元子序列</a>
 * @since 2023/1/29 09:58
 */
public class Solution_334 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        // 记录i的左侧最小值，即 0 到 i 的最小值
        int[] leftMin = new int[len];
        leftMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        // 记录i的右侧最大值，即 i 到 len-1 的最大值
        int[] rightMax = new int[len];
        rightMax[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        // 只要存在i的左侧存在小于它，并且右侧存在大于它的值即为true
        for (int i = 1; i < len - 1; i++) {
            if (leftMin[i] < nums[i] && rightMax[i] > nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        Solution_334 solution334 = new Solution_334();
        System.out.println(solution334.increasingTriplet(nums));
    }
}
