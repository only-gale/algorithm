package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/82_1.jpg" />
 * <pre>
 *    输入：head = [1,2,3,3,4,4,5]
 *    输出：[1,2,5]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：head = [1,1,1,2,3]
 *     输出：[2,3]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>链表中节点数目在范围 [0, 300] 内</li>
 *     <li>-100 <= Node.val <= 100</li>
 *     <li>题目数据保证链表已经按升序 排列</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">删除排序链表中的重复元素 II</a>
 * @since 2023/1/31 09:31
 */
public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        // 出现重复，必定至少两个元素
        if (head == null || head.next == null) {
            return head;
        }
        // slow和fast分别指代一前一后的两个元素，用于判断是否重复；同步前进
        // pre指代重复元素之前的节点，用于删除重复的节点
        ListNode slow = head, fast = head.next, pre = new ListNode();
        pre.next = head;
        // 当前slow和fast是否重复
        boolean flag = false;
        while (fast != null) {
            // 进入或者离开重复元素段
            if (slow.val != fast.val) {
                if (flag) { // 离开重复元素段
                    // 如果从头节点开始就重复，则修正头节点
                    if (pre.next == head) {
                        head = fast;
                    }
                    // 删除重复元素段
                    pre.next = fast;
                    // 断开重复元素段的指向，利于gc
                    slow.next = null;
                } else {    // 进入重复元素段
                    pre = pre.next;
                }
                flag = false;
                slow = fast;
                fast = fast.next;
            } else {
                // 发现重复元素
                flag = true;
                fast = fast.next;
                slow = slow.next;
            }
        }

        if (flag) { // 离开重复元素段
            // 如果从头节点开始就重复，则修正头节点
            if (pre.next == head) {
                head = null;
            }
            // 删除重复元素段
            pre.next = null;
            // 断开重复元素段的指向，利于gc
            slow.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        ListNode head = Util.assemble(nums);
        Solution_82 solution82 = new Solution_82();
        head = solution82.deleteDuplicates(head);
        System.out.println(Arrays.toString(Util.assemble(head)));
    }
}
