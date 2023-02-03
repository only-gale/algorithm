package com.gale.algorithm.leetcode;

import java.util.ArrayList;

/**
 * <p>给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>树中的节点数为 n 。</li>
 *     <li>1 <= k <= n <= 10^4</li>
 *     <li>0 <= Node.val <= 10^4</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/">二叉搜索树中第K小的元素</a>
 * @since 2023/2/3 14:30
 */
public class Solution_230 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> viewed = new ArrayList<>();
        postView(root, viewed);
        return viewed.get(k - 1);
    }

    public void postView(TreeNode root, ArrayList<Integer> viewed) {
        if (root != null) {
            if (root.left != null) {
                postView(root.left, viewed);
            }
            viewed.add(root.val);
            if (root.right != null) {
                postView(root.right, viewed);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5,3,6,2,4,null,null,1};
        int k = 3;
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Solution_230 solution230 = new Solution_230();
        System.out.println(solution230.kthSmallest(root, k));
    }
}
