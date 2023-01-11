package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：head = [1,2,3,4,5]
 *     输出：[5,4,3,2,1]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：head = [1,2]
 *     输出：[2,1]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：head = []
 *     输出：[]
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/">反转链表</a>
 * @since 2023/1/11 11:06
 */
public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode pre = null;
            while (head.next != null) {
                ListNode nxt = head.next;
                head.next = pre;
                pre = head;
                head = nxt;
            }
            head.next = pre;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = Util.assemble(nums);
        Solution_206 solution206 = new Solution_206();
        head = solution206.reverseList(head);
        System.out.println(Arrays.toString(Util.assemble(head)));
    }
}
