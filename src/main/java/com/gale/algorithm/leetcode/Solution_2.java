package com.gale.algorithm.leetcode;

/**
 * <p>给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。</p>
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src = "docFile/2_1.jpg" />
 * <pre>
 *     输入：l1 = [2,4,3], l2 = [5,6,4]
 *     输出：[7,0,8]
 *     解释：342 + 465 = 807.
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：l1 = [0], l2 = [0]
 *     输出：[0]
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *     输出：[8,9,9,9,0,0,0,1]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>每个链表中的节点数在范围 [1, 100] 内</li>
 *     <li>0 <= Node.val <= 9</li>
 *     <li>题目数据保证列表表示的数字不含前导零</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/">两数相加</a>
 * @since 2023/1/30 15:23
 */
public class Solution_2 {

    /**
     * 用l1作为结果列表，所以要始终保持l1的节点有效性（l1始终不会早于l2结束遍历）。当l1比l2短时，要把l2接到l1上，并断开l2
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 用l1作为结果列表，所以要始终保持l1的节点有效性（l1始终不会早于l2结束遍历）。当l1比l2短时，要把l2接到l1上，并断开l2
        // 边界条件判断
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 进位
        int plus = 0;
        // 结果链表头
        ListNode head = l1;

        while (l2 != null || plus > 0) {
            // 更新l1的值
            l1.val += plus;
            if (l2 != null) {
                l1.val += l2.val;
            }
            if (l1.val >= 10) {
                l1.val -= 10;
                plus = 1;
            } else {
                plus = 0;
            }

            // 更新l1的next

            // 当l1比l2短时，要把l2接到l1上，并断开l2
            if (l1.next == null && l2 != null && l2.next != null) {
                l1.next = l2.next;
                l2.next = null;
            }

            // 当l1行将结束遍历时（此时l2必定为null），根据进位判断是否需要补高位节点
            if (l1.next == null && plus > 0) {
                l1.next = new ListNode(plus);
                plus = 0;
            }

            l1 = l1.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4,3}, nums2 = {5,6,4};
        ListNode node1 = Util.assemble(nums1), node2 = Util.assemble(nums2);
        Solution_2 solution2 = new Solution_2();
        System.out.println(solution2.addTwoNumbers(node1, node2));
    }
}
