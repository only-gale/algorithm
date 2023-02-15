package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。</p>
 * <p>一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。</p>
 * <p>请你返回乘积为正数的最长子数组长度。</p>
 * <br>
 *
 * <p>示例  1：</p>
 * <pre>
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 10^5</li>
 *     <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/">乘积为正数的最长子数组长度</a>
 * @since 2023/2/14 16:44
 */
public class Solution_1567 {
    public int getMaxLen(int[] nums) {
        int l = nums.length, max = 0;
        int[] pos, neg;
        if (l == 1) {
            return nums[0] > 0 ? 1 : 0;
        }
        pos = new int[l];
        neg = new int[l];
        if (nums[0] > 0) {
            pos[0] = 1;
            max = 1;
        } else if (nums[0] < 0){
            neg[0] = 1;
        }
        for (int i = 1; i < l; i++) {
            if (nums[i] > 0) {
                pos[i] = pos[i - 1] + 1;
                neg[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
            } else if (nums[i] < 0){
                neg[i] = pos[i - 1] + 1;
                pos[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,-2,-3,-4};
        int[] nums = {1,-2,-3,4};
        Solution_1567 solution1567 = new Solution_1567();
        System.out.println(solution1567.getMaxLen(nums));
    }
}
