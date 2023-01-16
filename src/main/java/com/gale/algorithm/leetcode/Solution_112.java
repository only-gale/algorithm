package com.gale.algorithm.leetcode;

/**
 * <p>给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 *     输出：true
 *     解释：等于目标和的根节点到叶节点路径如上图所示。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：root = [1,2,3], targetSum = 5
 *     输出：false
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：root = [], targetSum = 0
 *     输出：false
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/path-sum/">路径总和</a>
 * @since 2023/1/16 11:27
 */
public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;
        TreeNode root = Util.assemble(nums);
        Solution_112 solution112 = new Solution_112();
        System.out.println(solution112.hasPathSum(root, targetSum));
    }
}
