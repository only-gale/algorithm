package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * <p>给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>
 * <p>子数组 是数组中的一个连续部分。</p>
 *
 * <p>示例 1</p>
 * <pre>
 *     输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 *     输出：6
 *     解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * </pre>
 *
 * <p>示例 2</p>
 * <pre>
 *     输入：nums = [1]
 *     输出：1
 * </pre>
 *
 * <p>示例 3</p>
 * <pre>
 *     输入：nums = [5,4,-1,7,8]
 *     输出：23
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/maximum-subarray/">最大子数组和</a>
 * @since 2023/1/4 10:43
 */
public class Solution_53 {
    // 只返回最大子序列之和
    public static int maxSubArray(int[] nums) {
        // dp数组：dp[i]表示以nums[i]结尾的子序列之和
//        int[] dp;

        // l: 数组长度
        // max: 最大子数组和
        // pre: 由于dp数组中，dp[i]只和dp[i - 1]有关，所以用pre优化
        int l, max, pre;

        if (nums == null || (l = nums.length) < 1) {
            return 0;
        }

        pre = nums[0];
        max = nums[0];
        for (int i = 1; i < l; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    // 返回最大子序列之和，并记录子序列坐标
    public static int maxSubArrayWithMemo(int[] nums) {
        // 用max记录最大子数组和，初始为第一个元素
        int l = nums.length, max = nums[0];
        // 最大值对应的连续子数组可能有多个，用set记录相应的子数组坐标
        Map<Integer, Set<Integer[]>> memo = new HashMap<>();
        // 初始记录为只包含第一个元素的子数组
        memo.put(max, new HashSet<Integer[]>(){{add(new Integer[]{0, 0});}});
        int[][] index = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                // 赋值
                if (j == i) {
                    index[i][j] = nums[i];
                } else {
                    index[i][j] = index[i][j - 1] + nums[j];
                }
                // 更新最大值max
                if (index[i][j] >= max) {
                    // 如果最大值被更新，则清除之前记录的所有子数组信息
                    if (index[i][j] > max) {
                        memo.clear();
                    }
                    max = index[i][j];
                    // 当前最大值所对应的子数组坐标
                    Integer[] integers = {i, j};
                    // 记录最大值所对应的子数组坐标
                    if (!memo.containsKey(max)) {
                        // 首次记录
                        memo.put(max, new HashSet<Integer[]>(){{add(integers);}});
                    } else {
                        // 追加记录
                        memo.get(max).add(integers);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Set<Integer[]>> e : memo.entrySet()) {
            System.out.println(e.getKey());
            for (Integer[] cord : e.getValue()) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(nums, cord[0], cord[1] + 1)));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayWithMemo(nums));
    }
}
