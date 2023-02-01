package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个单链表 L 的头节点 head ，单链表 L 表示为：</p>
 * <p>L0 → L1 → … → Ln - 1 → Ln</p>
 * <p>请将其重新排列后变为：</p>
 * <p>L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …</p>
 * <p>不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/143_1.png" />
 * <pre>
 *     输入：head = [1,2,3,4]
 *     输出：[1,4,2,3]
 * </pre>
 *
 * <p>示例 1：</p>
 * <img src="docFile/143_2.png" />
 * <pre>
 *     输入：head = [1,2,3,4,5]
 *     输出：[1,5,2,4,3]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>链表的长度范围为 [1, 5 * 104]</li>
 *     <li>1 <= node.val <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/reorder-list/">重排链表</a>
 * @since 2023/2/1 09:29
 */
public class Solution_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head, prev = null, mid, nxt;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        mid = slow;
        slow = slow.next;
        // 断开
        mid.next = null;
        // 反转slow到fast
        while (slow != null) {
            nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }
        // 反转后会形成两个链表：head和fast
        // 开始把fast按规则插入到head
        // 由于此时slow指向null，所以复用slow
        slow = head;
        while (fast != null) {
            prev = slow.next;
            nxt = fast.next;
            slow.next = fast;
            fast.next = prev;
            slow = prev;
            fast = nxt;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = Util.assemble(nums);
        Solution_143 solution143 = new Solution_143();
        solution143.reorderList(head);
        System.out.println(Arrays.toString(Util.assemble(head)));
    }
}
