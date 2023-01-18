package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。</p>
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums = [3,2,3]
 *     输出：3
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums = [2,2,1,1,1,2,2]
 *     输出：2
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>n == nums.length</li>
 *     <li>1 <= n <= 5 * 10^4</li>
 *     <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/majority-element/">多数元素</a>
 * @since 2023/1/18 10:05
 */
public class Solution_169 {
    public int majorityElement(int[] nums) {
        int l = nums.length, majorityThreshold = l >> 1;
        Map<Integer, Integer> nums2freq = new HashMap<>(majorityThreshold + 1);
        for (int n : nums) {
            int freq = nums2freq.getOrDefault(n, 0) + 1;
            if (freq > majorityThreshold) {
                return n;
            }
            nums2freq.put(n, freq);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Solution_169 solution169 = new Solution_169();
        System.out.println(solution169.majorityElement(nums));
    }
}
