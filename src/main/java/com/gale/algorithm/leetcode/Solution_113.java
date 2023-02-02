package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。</p>
 * <p>叶子节点 是指没有子节点的节点。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/113_1.jpg" />
 * <pre>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>树中节点总数在范围 [0, 5000] 内</li>
 *     <li>-1000 <= Node.val <= 1000</li>
 *     <li>-1000 <= targetSum <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/path-sum-ii/">路径总和 II</a>
 * @since 2023/2/2 14:46
 */
public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> trace = new ArrayList<>();
        backtrace(root, trace, 0, targetSum, ans);
        return ans;
    }

    /**
     * 回溯寻找路径和为targetSum的路径：整体思路是树的前序遍历和回溯算法
     * @param root      树根节点
     * @param trace     路径
     * @param curSum    当前路径和
     * @param targetSum 目标路径和
     * @param ans       所有符合条件的路径
     */
    public void backtrace(TreeNode root, List<Integer> trace, int curSum, int targetSum, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        trace.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == targetSum) {
            ans.add(new ArrayList<>(trace));
            trace.remove(trace.size() - 1);
            return;
        }
        backtrace(root.left, trace, curSum, targetSum, ans);
        backtrace(root.right, trace, curSum, targetSum, ans);
        trace.remove(trace.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Solution_113 solution113 = new Solution_113();
        List<List<Integer>> pathSum = solution113.pathSum(root, targetSum);
        System.out.println(pathSum);
    }
}
