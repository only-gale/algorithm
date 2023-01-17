package com.gale.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入: root = [5,3,6,2,4,null,7], k = 9
 *     输出: true
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入: root = [5,3,6,2,4,null,7], k = 28
 *     输出: false
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>-10^4 <= Node.val <= 10^4</li>
 *     <li>题目数据保证，输入的 root 是一棵 有效 的二叉搜索树</li>
 *     <li>-10^5 <= k <= 10^5</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/">两数之和 IV - 输入二叉搜索树</a>
 * @since 2023/1/17 15:24
 */
public class Solution_653 {
    private final Set<Integer> options = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        boolean leftFound = findTarget(root.left, k);
        if ((!options.isEmpty() && (options.contains(root.val) || options.contains(k - root.val)))) {
            return true;
        }
        options.add(root.val);
        boolean rightFound = findTarget(root.right, k);
        return leftFound || rightFound;
    }

    public static void main(String[] args) {
        Integer[] nums = {2,0,3,-4,1};
        int k = -1;
        TreeNode root = Util.assemble(nums);
        Util.printTreeAsLevelOrder(root);
        Solution_653 solution653 = new Solution_653();
        System.out.println(solution653.findTarget(root, k));
    }
}
