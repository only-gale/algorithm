package com.gale.algorithm.leetcode;

/**
 * <p>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。</p>
 * <p>示例 1：</p>
 * <pre>
 *     输入：l1 = [1,2,4], l2 = [1,3,4]
 *     输出：[1,1,2,3,4,4]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：l1 = [], l2 = []
 *     输出：[]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：l1 = [], l2 = [0]
 *     输出：[0]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>两个链表的节点数目范围是 [0, 50]</li>
 *     <li>-100 <= Node.val <= 100</li>
 *     <li>l1 和 l2 均按 非递减顺序 排列</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">合并两个有序链表</a>
 * @since 2023/1/10 10:42
 */
public class Solution_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 边界情况判断
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode n1 = list1,    // list1上的指针
                n2 = list2,     // list2上的指针
                little,         // 较小值节点
                head = null,    // 合并后的链表头
                cur = null;     // 合并后的链表指针
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                little = n1;
                n1 = n1.next;
            } else {
                little = n2;
                n2 = n2.next;
            }
            if (head == null) {
                head = little;
                cur = head;
            } else {
                cur.next = little;
                cur = cur.next;
            }
        }
        // 当n1还有剩余，则直接补到合并后的链表最后
        if (n1 != null) {
            cur.next = n1;
        }
        // 当n2还有剩余，则直接补到合并后的链表最后
        if (n2 != null) {
            cur.next = n2;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4}, nums2 = {1,3,4};
        ListNode list1 = Util.assemble(nums1), list2 = Util.assemble(nums2);
        Solution_21 solution21 = new Solution_21();
        ListNode ans = solution21.mergeTwoLists(list1, list2);
        System.out.println(ans);
    }
}
