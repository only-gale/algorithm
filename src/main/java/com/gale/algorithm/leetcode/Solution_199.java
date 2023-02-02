package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 * 输入: []
 * 输出: []
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>二叉树的节点个数的范围是 [0,100]</li>
 *     <li>-100 <= Node.val <= 100</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">二叉树的右视图</a>
 * @since 2023/2/2 14:36
 */
public class Solution_199 {

    /**
     * 树的右视图：从树的层序遍历结果中，每层取最后一个元素即可
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<List<Integer>> levelOrders = new ArrayList<>();
        levelOrder(root, 0, levelOrders);
        for (List<Integer> level : levelOrders) {
            if (level.size() > 0) {
                ans.add(level.get(level.size() - 1));
            }
        }
        return ans;
    }

    public void levelOrder(TreeNode root, int level, List<List<Integer>> ans) {
        if (root != null) {
            if (level >= ans.size()) {
                for (int i = ans.size(); i <= level; i++) {
                    ans.add(new ArrayList<>());
                }
            }
            ans.get(level).add(root.val);
            levelOrder(root.left, level + 1, ans);
            levelOrder(root.right, level + 1, ans);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,null,5,null,4};
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Solution_199 solution199 = new Solution_199();
        System.out.println(solution199.rightSideView(root));
    }
}
