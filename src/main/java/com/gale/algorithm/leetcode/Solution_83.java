package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：head = [1,1,2]
 *     输出：[1,2]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：head = [1,1,2,3,3]
 *     输出：[1,2,3]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>链表中节点数目在范围 [0, 300] 内</li>
 *     <li>-100 <= Node.val <= 100</li>
 *     <li>题目数据保证链表已经按升序 排列</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/"> 删除排序链表中的重复元素</a>
 * @since 2023/1/11 11:35
 */
public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, nxt;
        while (cur != null && (nxt = cur.next) != null) {
            if (cur.val == nxt.val) {
                cur.next = nxt.next;
                nxt.next = null;
            } else {
                cur = nxt;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        ListNode head = Util.assemble(nums);
        Solution_83 solution83 = new Solution_83();
        head = solution83.deleteDuplicates(head);
        System.out.println(Arrays.toString(Util.assemble(head)));
    }
}
