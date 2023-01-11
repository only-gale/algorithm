package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工具类
 * @since 2023/1/10 10:46
 */
public class Util {
    public static Map<Integer, Integer> mapIndex(String s) {
        if (isStringEmpty(s)) {
            return new HashMap<>();
        }
        Map<Integer, Integer> index = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            index.put(c, index.getOrDefault(c, 0) + 1);
        }
        return index;
    }

    public static boolean isStringEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isArrayEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public static ListNode assemble(int[] nums) {
        if (isArrayEmpty(nums)) {
            return null;
        }
        ListNode head = new ListNode(nums[0]), cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;

        }
        return head;
    }

    public static ListNode assemble(int[] nums, int pos) {
        if (isArrayEmpty(nums)) {
            return null;
        }
        ListNode head = new ListNode(nums[0]), cur = head, cycleNode = null;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            if (i == pos) {
                cycleNode = cur.next;
            }
            cur = cur.next;

        }

        if (cycleNode != null) {
            cur.next = cycleNode;
        }
        return head;
    }

    public static void printBoard(List<List<String>> board) {
        for (List<String> line : board) {
            for (int i = 0; i < line.size(); i++) {
                String s = line.get(i);
                if (i == (line.size() - 1)) {
                    System.out.print(s);
                } else {
                    System.out.printf("%s ", s);
                }
            }
            System.out.println();
        }
    }

    public static void printBoard(int[][] board) {
        for (int[] line : board) {
            for (int i = 0; i < line.length; i++) {
                int s = line[i];
                if (i == (line.length - 1)) {
                    System.out.print(s);
                } else {
                    System.out.printf("%d ", s);
                }
            }
            System.out.println();
        }
    }

    public static int[] assemble(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
