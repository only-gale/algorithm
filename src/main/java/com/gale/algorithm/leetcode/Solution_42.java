package com.gale.algorithm.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * <p>示例1</p>
 * <pre>
 *     输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *     输出：6
 * </pre>
 *
 * <p>示例2</p>
 * <pre>
 *     输入：height = [4,2,0,3,2,5]
 *     输出：9
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/trapping-rain-water/">接雨水</a>
 */
public class Solution_42 {
    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int left = 0, right = n - 1;
        int ans = 0;
        int l_max = height[0], r_max = height[n - 1];
        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if (l_max < r_max) {
                ans += (l_max - height[left]);
                left++;
            } else {
                ans += (r_max - height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }
}
