package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：root = [1]
 * 输出：[[1]]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：root = []
 * 输出：[]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>树中节点数目在范围 [0, 2000] 内</li>
 *     <li>-100 <= Node.val <= 100</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">二叉树的锯齿形层序遍历</a>
 * @since 2023/2/2 14:09
 */
public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        levelOrder(root, 0, ans);
        for (int i = 0; i < ans.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(ans.get(i));
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
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Solution_103 solution103 = new Solution_103();
        List<List<Integer>> zigzagLevelOrder = solution103.zigzagLevelOrder(root);
        System.out.println(zigzagLevelOrder);
    }
}
