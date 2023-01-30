package com.gale.algorithm.leetcode;

/**
 * <p>给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。</p>
 * <p>如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。</p>
 * <p>不允许修改 链表。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/142_1.png" />
 * <pre>
 *     输入：head = [3,2,0,-4], pos = 1
 *     输出：返回索引为 1 的链表节点
 *     解释：链表中有一个环，其尾部连接到第二个节点。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：head = [1,2], pos = 0
 *     输出：返回索引为 0 的链表节点
 *     解释：链表中有一个环，其尾部连接到第一个节点。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：head = [1], pos = -1
 *     输出：返回 null
 *     解释：链表中没有环。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>链表中节点的数目范围在范围 [0, 10^4] 内</li>
 *     <li>-10^5 <= Node.val <= 10^5</li>
 *     <li>pos 的值为 -1 或者链表中的一个有效索引</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">环形链表 II</a>
 * @since 2023/1/30 16:50
 */
public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        // 发现环之前，slow走一步，fast走两步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 发现环，并且相遇点在head，则直接返回，否则后面改成同步走就成死循环了
                if (fast == head) {
                    return slow;
                }
                // 发现环，并且相遇点不在head，重置slow到head
                slow = head;
                break;
            }
        }

        // 有环的情况才会进循环
        // 发现环之后改为同步走
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        int pos = 1;
        ListNode head = Util.assembleCircle(nums, pos);
        Solution_142 solution142 = new Solution_142();
        ListNode joinPoint = solution142.detectCycle(head);
        System.out.println(joinPoint);
    }
}
