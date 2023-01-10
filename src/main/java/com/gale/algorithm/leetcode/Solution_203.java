package com.gale.algorithm.leetcode;

/**
 * <p>给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：head = [1,2,6,3,4,5,6], val = 6
 *     输出：[1,2,3,4,5]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：head = [], val = 1
 *     输出：[]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：head = [7,7,7,7], val = 7
 *     输出：[]
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/remove-linked-list-elements/">移除链表元素</a>
 * @since 2023/1/10 11:15
 */
public class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode
                virtualHead = new ListNode(),   // 虚拟节点，next指向head
                cur = head,                     // 当前节点指针
                last = virtualHead;             // 当前节点的上一个节点
        virtualHead.next = head;

        while (cur != null) {
            if (cur.val == val) {
                // 断开上一节点对当前节点的next指向
                last.next = cur.next;
                // 断开next
                cur.next = null;
                // 至此，当前节点将被gc
                // cur前进
                cur = last.next;
            } else {
                // cur前进
                cur = cur.next;
                // cur的上一节点指针前进
                last = last.next;
            }
        }
        return virtualHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7};
        int val = 7;
        ListNode head = Util.assemble(nums);
        Solution_203 solution203 = new Solution_203();
        head = solution203.removeElements(head, val);
        System.out.println(head);
    }
}
