package com.gale.algorithm.leetcode;

/**
 * <p>给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。</p>
 * <p>注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：root = [4,2,7,1,3], val = 5
 *     输出：[4,2,7,1,3,5]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：root = [40,20,60,10,30,50,70], val = 25
 *     输出：[40,20,60,10,30,50,70,null,null,25]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 *     输出：[4,2,7,1,3,5]
 * </pre>
 *
 * 注意：
 * <ul>
 *     <li>所有值 Node.val 是 独一无二 的。</li>
 *     <li>保证 val 在原始BST中不存在。</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/">二叉搜索树中的插入操作</a>
 * @since 2023/1/16 14:04
 */
public class Solution_701 {

    /**
     * 将val插入二叉搜索树
     * <p>本方法没有考虑root的平衡</p>
     * @param root 二叉搜索树
     * @param val  待插入的值
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3};
        int val = 5;
        TreeNode root = Util.assemble(nums);
        Solution_701 solution701 = new Solution_701();
        root = solution701.insertIntoBST(root, val);
        Util.printTreeAsLevelOrder(root);
    }
}
