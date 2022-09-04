package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。</p>
 *
 * <p><i>子序列</i> 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * <p>示例1</p>
 * <pre>
 *     输入：nums = [10,9,2,5,3,7,101,18]
 *     输出：4
 *     最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * </pre>
 *
 * <p>示例2</p>
 * <pre>
 *     输入：nums = [0,1,0,3,2,3]
 *     输出：4
 * </pre>
 * @see <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">最长递增子序列</a>
 */
public class Solution_300 {
    public static int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int poker : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        nums = new int[]{2,3,7,101};
        System.out.println(lengthOfLIS(nums));
    }
}
