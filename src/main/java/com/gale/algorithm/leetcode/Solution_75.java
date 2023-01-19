package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。</p>
 * <p>我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。</p>
 * <p>必须在不使用库内置的 sort 函数的情况下解决这个问题。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums = [2,0,2,1,1,0]
 *     输出：[0,0,1,1,2,2]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums = [2,0,1]
 *     输出：[0,1,2]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>n == nums.length</li>
 *     <li>1 <= n <= 300</li>
 *     <li>nums[i] 为 0、1 或 2</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/sort-colors/">颜色分类</a>
 * @since 2023/1/19 09:42
 */
public class Solution_75 {
    public void sortColors(int[] nums) {
        int l = nums.length, i = 0, j = l - 1, k;
        boolean swapped;

        if (l == 1) {
            return;
        }

        if (l == 2) {
            if (nums[i] > nums[j]) {
                Util.swap(nums, i, j);
            }
            return;
        }

        while (i < j) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[j] == 2) {
                j--;
                continue;
            }

            if (nums[i] == 2) {
                Util.swap(nums, i, j--);
                continue;
            }
            if (nums[j] == 0) {
                Util.swap(nums, i++, j);
                continue;
            }

            // 此时i和j指向的值都是1
            swapped = false;
            if (nums[i] == 1 && (k = findSwapIndex4i(nums, i, j)) != -1) {
                Util.swap(nums, i, k);
                swapped = true;
            }
            if (nums[j] == 1 && (k = findSwapIndex4j(nums, i, j)) != -1) {
                Util.swap(nums, j, k);
                swapped = true;
            }
            if (!swapped) {
                break;
            }
        }
    }

    private int findSwapIndex4i(int[] nums, int i, int j) {
        for (int k = i + 1; k < j; k++) {
            if (nums[k] != 1) {
                return k;
            }
        }
        return -1;
    }

    private int findSwapIndex4j(int[] nums, int i, int j) {
        for (int k = j - 1; k > i; k--) {
            if (nums[k] != 1) {
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution_75 solution75 = new Solution_75();
        solution75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
