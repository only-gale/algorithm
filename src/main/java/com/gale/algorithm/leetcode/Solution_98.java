package com.gale.algorithm.leetcode;

/**
 * <p>给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。</p>
 * <p>有效 二叉搜索树定义如下：</p>
 * <ul>
 *     <li>节点的左子树只包含 小于 当前节点的数。</li>
 *     <li>节点的右子树只包含 大于 当前节点的数。</li>
 *     <li>所有左子树和右子树自身必须也是二叉搜索树。</li>
 * </ul>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：root = [2,1,3]
 *     输出：true
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：root = [5,1,4,null,null,3,6]
 *     输出：false
 *     解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>树中节点数目范围在[1, 10^4] 内</li>
 *     <li>-2^31 <= Node.val <= 2^31 - 1</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 * @since 2023/1/17 09:30
 */
public class Solution_98 {
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return isValidBSTInOrder(root);
    }

    public boolean isValidBSTInOrder(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftValidBST = isValidBST(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean isRightValidBST = isValidBST(root.right);

        return isLeftValidBST && isRightValidBST;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,1};
        TreeNode root = Util.assemble(nums);
        Solution_98 solution98 = new Solution_98();
        Util.printTreeAsLevelOrder(root);
        System.out.println(solution98.isValidBST(root));
    }
}
