package com.gale.algorithm.leetcode;

/**
 * <p>给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。</p>
 * <p>请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。</p>
 * <p>你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= k <= nums.length <= 10^5</li>
 *     <li>-10^4 <= nums[i] <= 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">数组中的第K个最大元素</a>
 * @since 2023/2/6 17:20
 */
public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, nums.length);
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums, int l) {
        for (int i = (l >> 1) - 1 ; i >= 0; i--) {
            heapify(nums, l, i);
        }
    }

    public void heapify(int[] nums, int count, int idx) {
        int max = idx, ldx, rdx;
        while (true) {
            ldx = (idx << 1) + 1;
            rdx = ldx + 1;
            if (ldx < count && nums[ldx] > nums[max]) {
                max = ldx;
            }
            if (rdx < count && nums[rdx] > nums[max]) {
                max = rdx;
            }
            if (max == idx) {
                break;
            }
            swap(nums, idx, max);
            idx = max;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        Solution_215 solution215 = new Solution_215();
        System.out.println(solution215.findKthLargest(nums, k));
    }
}
