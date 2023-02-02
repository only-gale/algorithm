package com.gale.algorithm.leetcode;

/**
 * <p>给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。</p>
 * <p>高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 10^4</li>
 *     <li>-10^4 <= nums[i] <= 10^4</li>
 *     <li>nums 按 严格递增 顺序排列</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">将有序数组转换为二叉搜索树</a>
 * @since 2023/2/2 10:49
 */
public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST0(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST0(int[] nums, int i, int j) {
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int mid = i + ((j - i) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        if (mid - 1 >= i) {
            root.left = sortedArrayToBST0(nums, i, mid - 1);
        }
        if (mid + 1 <= j) {
            root.right = sortedArrayToBST0(nums, mid + 1, j);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        Solution_108 solution108 = new Solution_108();
        TreeNode root = solution108.sortedArrayToBST(nums);
        Util.printTreeAsLevelOrder(root);
    }
}
