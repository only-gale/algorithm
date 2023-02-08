package com.gale.algorithm.leetcode;

/**
 * <p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>
 * <p>最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/236_1.png" />
 * <pre>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>树中节点数目在范围 [2, 10^5] 内。</li>
 *     <li>-10^9 <= Node.val <= 10^9</li>
 *     <li>所有 Node.val 互不相同 。</li>
 *     <li>p != q</li>
 *     <li>p 和 q 均存在于给定的二叉树中。</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">二叉树的最近公共祖先</a>
 * @since 2023/2/6 09:37
 */
public class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q), r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }

    public static void main(String[] args) {
        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode p = new TreeNode(5), q = new TreeNode(1);
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Solution_236 solution236 = new Solution_236();
        TreeNode lowestCommonAncestor = solution236.lowestCommonAncestor(root, p, q);
        System.out.println(lowestCommonAncestor.val);
    }
}
