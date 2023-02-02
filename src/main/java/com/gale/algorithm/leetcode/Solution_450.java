package com.gale.algorithm.leetcode;

/**
 * <p>给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。</p>
 * <p>返回二叉搜索树（有可能被更新）的根节点的引用。</p>
 * <br>
 * <p>一般来说，删除节点可分为两个步骤：</p>
 * <ol>
 *     <li>首先找到需要删除的节点；</li>
 *     <li>如果找到了，删除它。</li>
 * </ol>
 * <br>
 *
 * <p>示例 1:</p>
 * <img src="docFile/450_1.jpg" />
 * <pre>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <img src="docFile/450_2.jpg" />
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 * 输入: root = [], key = 0
 * 输出: []
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>节点数的范围 [0, 10^4]</li>
 *     <li>-10^5 <= Node.val <= 10^5</li>
 *     <li>节点值唯一</li>
 *     <li>root 是合法的二叉搜索树</li>
 *     <li>-10^5 <= key <= 10^5</li>
 * </ul>
 *
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-bst/">删除二叉搜索树中的节点</a>
 * @since 2023/2/2 15:17
 */
public class Solution_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 找到了，进行删除
        if (root.val == key) {
            return mergeAsBST(root.left, root.right);
        }
        // 没找到
        boolean delete = false;
        // 尝试从左子树删除
        if (root.left != null) {
            int val = root.left.val;
            root.left = deleteNode(root.left, key);
            delete = root.left == null || root.left.val != val;
        }
        // 左子树也没删到，则尝试从右子树删除
        if (!delete && root.right != null) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 删除BST根节点后，将左右子树合并成一个新的BST
     * <p>新的BST根节点选择策略很多，这里只做简单选择：在左右子树都不为空的情况下，选择左子树的根节点为新的BST的根节点</p>
     * @param left  BST左子树
     * @param right BST右子树
     * @return 新的BST根节点
     */
    public TreeNode mergeAsBST(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // 左右子树都不为空

        // 因为要将左子树的根节点提升，右子树只能成为左子树的右子树
        // 所以当左子树的右子树为空时，直接使用右子树
        if (left.right == null) {
            left.right = right;
        } else if (right.left == null) {    // 否则当右子树的左子树为空时，直接将左子树的右子树挂到右子树的左子树，并将原右子树直接提升为原左子树的右子树
            right.left = left.right;
            left.right = right;
        } else {    // 否则近一步合并
            right.left = mergeAsBST(left.right, right.left);
            left.right = right;
        }
        return left;
    }

    public static void main(String[] args) {
//        Integer[] nums = {5,3,7,2,4,6,8};
        Integer[] nums = {5,3,6,2,4,null,7};
        int key = 7;
        TreeNode root = Util.assembleFromLevelOrder(nums);
        Solution_450 solution450 = new Solution_450();
        root = solution450.deleteNode(root, key);
        Util.printTreeAsLevelOrder(root);
    }
}
