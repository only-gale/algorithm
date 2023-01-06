package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * <p>给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums1 = [1,2,2,1], nums2 = [2,2]
 *     输出：[2,2]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *     输出：[4,9]
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">两个数组的交集 II</a>
 * @since 2023/1/6 10:06
 */
public class Solution_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 任意一个数组为空，交集都为空
        if (isEmpty(nums1) || isEmpty(nums2)) {
            return new int[]{};
        }

        // 调整nums1为较短数组
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // 为了节省空间，保存较短数组的 元素->次数 映射
        Map<Integer, Integer> index = new HashMap<>();
        for (int n : nums1) {
            index.put(n, index.getOrDefault(n, 0) + 1);
        }

        // 保存结果列表
        List<Integer> rs = new ArrayList<>(nums1.length);

        // 遍历较长数组nums2
        for (int n : nums2) {
            // 在nums1中出现
            // 且判断出现的次数，满足（如果出现次数不一致，则考虑取较小值）
            if (index.containsKey(n) && index.get(n) > 0) {
                rs.add(n);
                // 在nums1中出现的次数 - 1
                index.replace(n, index.get(n) - 1);
            }
        }
        // 转换结果列表为整数数组
        return rs.stream().mapToInt(n -> n).toArray();
    }

    private static boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
