package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/24_1.jpg" />
 * <pre>
 *     输入：head = [1,2,3,4]
 *     输出：[2,1,4,3]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：head = []
 *     输出：[]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：head = [1]
 *     输出：[1]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>链表中节点的数目在范围 [0, 100] 内</li>
 *     <li>0 <= Node.val <= 100</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">两两交换链表中的节点</a>
 * @since 2023/1/31 10:48
 */
public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        // 至少两个节点才可以完成交换
        if (head == null || head.next == null) {
            return head;
        }
        // slow和fast分别指代需要交换的两个节点
        // tmp指向下一组的头节点
        // dummy指向上一组的尾节点
        ListNode slow = head, fast = head.next, tmp, dummy = new ListNode();
        dummy.next = head;
        while (slow != null && fast != null) {
            // 先记住下一组
            tmp = fast.next;
            // 交换
            slow.next = null;
            fast.next = slow;

            // 修正头节点head
            if (dummy.next == head) {
                head = fast;
            }
            // 连接：将上一组的尾节点连接到下一组的头节点
            // 下一组交换后的头节点是fast，尾节点是slow
            dummy.next = fast;
            dummy = slow;

            // 准备交换下一组
            slow = tmp;
            if (slow != null) {
                fast = slow.next;
            }
        }

        // 剩余不足以交换的元素直接连接
        if (slow != null) {
            dummy.next = slow;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ListNode head = Util.assemble(nums);
        Solution_24 solution24 = new Solution_24();
        head = solution24.swapPairs(head);
        System.out.println(Arrays.toString(Util.assemble(head)));
    }
}
