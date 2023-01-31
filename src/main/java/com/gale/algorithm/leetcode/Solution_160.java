package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。</p>
 * <p>图示两个链表在节点 c1 开始相交：</p>
 * <img src="docFile/160_1.png" />
 * <p>题目数据 保证 整个链式结构中不存在环。</p>
 * <p>注意，函数返回结果后，链表必须 保持其原始结构 。</p>
 *
 * @see <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">相交链表</a>
 * @since 2023/1/30 17:50
 */
public class Solution_160 {

    /**
     * 双指针
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA1 = headA, headB1 = headB;
        boolean needAppendB = true, needAppendA = true;
        while (headA1 != null || headB1 != null) {
            if (headA1 == headB1) {
                return headA1;
            }
            if (headA1 != null) {
                if (needAppendB && headA1.next == null) {
                    headA1 = headB;
                    needAppendB = false;
                } else {
                    headA1 = headA1.next;
                }
            }
            if (headB1 != null) {
                if (needAppendA && headB1.next == null) {
                    headB1 = headA;
                    needAppendA = false;
                } else {
                    headB1 = headB1.next;
                }
            }
        }
        return null;
    }

    public ListNode getIntersectionNode_map(ListNode headA, ListNode headB) {
        Map<Integer, Integer> map = new HashMap<>();
        while (headA != null) {
            int hashCodeA = headA.hashCode();
            map.put(hashCodeA, map.getOrDefault(hashCodeA, 0) + 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB.hashCode())) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
