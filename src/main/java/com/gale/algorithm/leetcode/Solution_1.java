package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。</p>
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>
 * <p>你可以按任意顺序返回答案。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums = [2,7,11,15], target = 9
 *     输出：[0,1]
 *     解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 * @since 2023/1/5 10:15
 */
public class Solution_1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] err = {-1, -1};
        if (nums == null || nums.length < 2) {
            return err;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // 数组中同一个元素在答案里不能重复出现
            // 所以j从i的下一个位置开始
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    // 每种输入只会对应一个答案
                    return new int[]{i, j};
                }
            }
        }
        return err;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
