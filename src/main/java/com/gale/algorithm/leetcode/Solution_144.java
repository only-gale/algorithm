package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你二叉树的根节点 root ，返回它节点值的 前序 中序 后序 遍历。</p>
 * @see <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">二叉树的前序遍历</a>
 * @see <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">二叉树的中序遍历</a>
 * @see <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">二叉树的后序遍历</a>
 * @since 2023/1/13 16:33
 */
public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }
}
