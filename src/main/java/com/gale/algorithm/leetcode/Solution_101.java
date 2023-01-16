package com.gale.algorithm.leetcode;

/**
 * <p>给你一个二叉树的根节点 root ， 检查它是否轴对称。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：root = [1,2,2,3,4,4,3]
 *     输出：true
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：root = [1,2,2,null,3,null,3]
 *     输出：false
 * </pre>
 * @see <a href="https://leetcode.cn/problems/symmetric-tree/">对称二叉树</a>
 * @since 2023/1/16 10:59
 */
public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        return (left == null && right == null) || (left != null && right != null && left.val == right.val) && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,2,null,3,null,3};
        TreeNode root = Util.assemble(nums);
        Solution_101 solution101 = new Solution_101();
        System.out.println(solution101.isSymmetric(root));
    }
}
