package com.gale.algorithm.leetcode;

/**
 * <p>给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。</p>
 * <p>公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”</p>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *     输出: 6
 *     解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *     输出: 2
 *     解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * </pre>
 *
 * 说明:
 * <ul>
 *     <li>所有节点的值都是唯一的。</li>
 *     <li>p、q 为不同节点且均存在于给定的二叉搜索树中。</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/">二叉搜索树的最近公共祖先</a>
 * @since 2023/1/17 15:47
 */
public class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root为空，则没找到
        // 如果root是p和q其中一个，则此时p或q的最近祖先是它自己，直接返回
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 左边找的结果
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        // 右边找的结果
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // 左右都找到了，说明p和q分布在两边，所以要返回root
        if (l != null && r != null) {
            return root;
        }

        // 哪边找到了返回哪边
        return l == null ? r : l;
    }

    public static void main(String[] args) {
        Integer[] nums = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = Util.assemble(nums), p = new TreeNode(2), q = new TreeNode(4);
        Util.printTreeAsLevelOrder(root);

        Solution_235 solution235 = new Solution_235();
        TreeNode ans = solution235.lowestCommonAncestor(root, p, q);
        Util.printTreeAsLevelOrder(ans);
    }
}
