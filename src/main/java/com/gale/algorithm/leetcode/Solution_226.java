package com.gale.algorithm.leetcode;

/**
 * <p>给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：root = [4,2,7,1,3,6,9]
 *     输出：[4,7,2,9,6,3,1]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：root = [2,1,3]
 *     输出：[2,3,1]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：root = []
 *     输出：[]
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/invert-binary-tree/">翻转二叉树</a>
 * @since 2023/1/16 11:19
 */
public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = Util.assemble(nums);
        Solution_226 solution226 = new Solution_226();
        Util.printTreeAsLevelOrder(solution226.invertTree(root));
    }
}
