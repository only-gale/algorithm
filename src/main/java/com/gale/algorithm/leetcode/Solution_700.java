package com.gale.algorithm.leetcode;

/**
 * <p>给定二叉搜索树（BST）的根节点 root 和一个整数值 val。</p>
 * <p>你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。</p>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入：root = [4,2,7,1,3], val = 2
 *     输出：[2,1,3]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入：root = [4,2,7,1,3], val = 5
 *     输出：[]
 * </pre>
 * @see <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">二叉搜索树中的搜索</a>
 * @since 2023/1/16 13:57
 */
public class Solution_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode searched = searchBST(root.left, val);
        return searched == null ? searchBST(root.right, val) : searched;
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3};
        TreeNode root = Util.assemble(nums);
        int val = 2;
        Solution_700 solution700 = new Solution_700();
        TreeNode treeNode = solution700.searchBST(root, val);
        Util.printTreeAsLevelOrder(treeNode);
    }
}
