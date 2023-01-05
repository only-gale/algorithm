package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。</p>
 * <p>请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。</p>
 * <p>注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *     输出：[1,2,2,3,5,6]
 *     解释：需要合并 [1,2,3] 和 [2,5,6] 。
 *     合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums1 = [1], m = 1, nums2 = [], n = 0
 *     输出：[1]
 *     解释：需要合并 [1] 和 [] 。
 *     合并结果是 [1] 。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 *     输出：[1]
 *     解释：需要合并的数组是 [] 和 [1] 。
 *     合并结果是 [1] 。
 *     注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/merge-sorted-array/">合并两个有序数组</a>
 * @since 2023/1/5 10:34
 */
public class Solution_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1的后面n个位置是空的，所以倒序遍历可以优化大量移动
        // idx1指向nums1中属于nums1的最后一位，idx2指向nums2的最后一位，last指向nums1的最后一位
        int idx1 = m - 1, idx2 = n - 1, last = nums1.length - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            // 由于nums1和nums2都是非递减顺序
            // 属于last位置的值可以由nums1的最后一位和nums2的最后一位做比较得出
            // idx2先耗完时，剩下的idx1部分不用动
            nums1[last--] = nums1[idx1] > nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
        }

        // idx1先耗完时，剩下的idx2部分需要从nums2拷贝到nums1里去
        if (idx2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, idx2 + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6,0}, nums2 = {3};
        int m = 5, n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
