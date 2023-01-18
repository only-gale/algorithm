package com.gale.algorithm.leetcode;

/**
 * <p>给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。</p>
 * <p>你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。</p>
 *
 * <p>示例 1 ：</p>
 * <pre>
 *     输入：nums = [2,2,1]
 *     输出：1
 * </pre>
 *
 * <p>示例 2 ：</p>
 * <pre>
 *     输入：nums = [4,1,2,1,2]
 *     输出：4
 * </pre>
 *
 * <p>示例 3 ：</p>
 * <pre>
 *     输入：nums = [1]
 *     输出：1
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 3 * 10^4</li>
 *     <li>-3 * 10^4 <= nums[i] <= 3 * 10^4</li>
 *     <li>除了某个元素只出现一次以外，其余每个元素均出现两次。</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/single-number/">只出现一次的数字</a>
 * @since 2023/1/18 09:27
 */
public class Solution_136 {
    public int singleNumber(int[] nums) {
        int l = nums.length, cur = nums[0];
        if (l > 1) {
            for (int i = 1; i < l; i++) {
                // 位异或操作，两个不同的数异或，结果数字中保留了两个数的全部有效位，再异或其中一个相同的数，则从结果数中删掉这个数的有效位，那么结果数中保留了另一位数
                cur ^= nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1};
        Solution_136 solution136 = new Solution_136();
        System.out.println(solution136.singleNumber(nums));
    }
}
