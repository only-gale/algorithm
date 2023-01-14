package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。</p>
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/"> 二叉树的层序遍历</a>
 * @since 2023/1/14 22:14
 */
public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        loopLevelOrder(ans, root, 0);
        return ans;
    }

    public void loopLevelOrder(List<List<Integer>> ans, TreeNode root, int depth) {
        if (root != null) {
            doLevelOrder(ans, root, depth);
            if (root.left != null || root.right != null) {
                loopLevelOrder(ans, root.left, ++depth);
                loopLevelOrder(ans, root.right, depth);
            }
        }
    }

    public void doLevelOrder(List<List<Integer>> ans, TreeNode root, int depth) {
        if (root != null) {
            // 初始化
            if (depth == ans.size()) {
                ans.add(depth, new ArrayList<>());
            }
            List<Integer> result = ans.get(depth);
            if (result == null) {
                result = new ArrayList<>();
            }

            result.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution_102 solution102 = new Solution_102();
        List<List<Integer>> levelOrder = solution102.levelOrder(root);
        System.out.println(levelOrder);
    }
}
