package com.gale.algorithm.leetcode;

/**
 * <p>给定一个二叉树，找出其最大深度。</p>
 * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>
 * <p>说明: 叶子节点是指没有子节点的节点。</p>
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a>
 * @since 2023/1/16 10:47
 */
public class Solution_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = Util.assemble(nums);

        Solution_104 solution104 = new Solution_104();
        System.out.println(solution104.maxDepth(root));
    }
}
