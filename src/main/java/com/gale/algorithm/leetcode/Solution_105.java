package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * </pre>
 *
 * <ul>
 *     <li>1 <= preorder.length <= 3000</li>
 *     <li>inorder.length == preorder.length</li>
 *     <li>-3000 <= preorder[i], inorder[i] <= 3000</li>
 *     <li>preorder 和 inorder 均 无重复 元素</li>
 *     <li>inorder 均出现在 preorder</li>
 *     <li>preorder 保证 为二叉树的前序遍历序列</li>
 *     <li>inorder 保证 为二叉树的中序遍历序列</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">从前序与中序遍历序列构造二叉树</a>
 * @since 2023/2/2 11:16
 */
public class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        // 因为不存在重复元素，所以可以通过map在O(1)时间内找到根节点在中序遍历结果数组中的下表
        // 从而快速知道左右子树分别有多少元素，进而可以计算出左右子树在前序遍历结果数组中的索引范围
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, 0, inorder.length - 1, inIndex);
    }

    /**
     * 根据前序和中序遍历结果还原树
     * @param preorder 前序遍历结果数组
     * @param preLeft  前序遍历结果数组中根节点的索引
     * @param inLeft   中序遍历结果数组中子树的所有节点的起始索引（包含）
     * @param inRight  中序遍历结果数组中子树的所有节点的截止索引（包含）
     * @param inIndex  中序遍历结果数组的索引映射
     */
    public TreeNode buildTree(int[] preorder, int preLeft, int inLeft, int inRight, Map<Integer, Integer> inIndex) {
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = inIndex.get(root.val), leftChildrenCount = rootIndex - inLeft, rightChildrenCount = inRight - rootIndex;
        if (leftChildrenCount > 0) {
            root.left = buildTree(preorder, preLeft + 1, inLeft, rootIndex - 1, inIndex);
        }

        if (rightChildrenCount > 0) {
            root.right = buildTree(preorder, preLeft + leftChildrenCount + 1, rootIndex + 1, inRight, inIndex);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
//        int[] preorder = {1,2}, inorder = {1,2};
        Solution_105 solution105 = new Solution_105();
        TreeNode root = solution105.buildTree(preorder, inorder);
        Util.printTreeAsLevelOrder(root);
    }
}
