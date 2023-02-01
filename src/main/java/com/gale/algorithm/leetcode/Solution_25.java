package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。</p>
 * <p>k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。</p>
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/25_1.jpg" />
 * <pre>
 *     输入：head = [1,2,3,4,5], k = 2
 *     输出：[2,1,4,3,5]
 * </pre>
 *
 * <p>示例 2：</p>
 * <img src="docFile/25_2.jpg" />
 * <pre>
 *     输入：head = [1,2,3,4,5], k = 3
 *     输出：[3,2,1,4,5]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>链表中的节点数目为 n</li>
 *     <li>1 <= k <= n <= 5000</li>
 *     <li>0 <= Node.val <= 1000</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">K 个一组翻转链表</a>
 * @since 2023/1/31 17:38
 */
public class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode groupHead = head, groupTail = head, preTail = new ListNode(), nxtHead;
        preTail.next = head;
        do {
            // 寻找可交换组：k个一组，即走k-1步
            int step = k - 1;
            while (groupTail != null && step > 0) {
                groupTail = groupTail.next;
                step--;
            }
            // 找到了
            if (groupTail != null) {
                // 先拿到下一组的头节点
                nxtHead = groupTail.next;

                // 开始交换
                ListNode nxt, tmp = groupHead, prev = null;
                while (tmp != nxtHead) {
                    nxt = tmp.next;
                    tmp.next = prev;
                    prev = tmp;
                    tmp = nxt;
                }

                // 开始修正

                // 交换后组头变组尾，组尾变组头
                if (preTail.next == head) {
                    head = groupTail;
                }
                preTail.next = groupTail;
                preTail = groupHead;

                // 上一组尾连接下一组头，保证每次交换完成后的链表完整性
                preTail.next = nxtHead;

                // 准备交换下一组
                groupHead = nxtHead;
                groupTail = groupHead;
            }
        } while (groupTail != null);

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        ListNode head = Util.assemble(nums);
        Solution_25 solution25 = new Solution_25();
        head = solution25.reverseKGroup(head, k);
        System.out.println(Arrays.toString(Util.assemble(head)));
    }
}
