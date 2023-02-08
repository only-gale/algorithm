package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * 工具类
 * @since 2023/1/10 10:46
 */
public class Util {

    /**
     * 映射s中字符及其频率
     * @param s 字符串
     */
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

    /**
     * 映射nums中数字及其频率
     * @param nums 整数数组
     */
    public static Map<Integer, Integer> mapIndex(int[] nums) {
        Map<Integer, Integer> num2freq = new HashMap<>();
        for (int value : nums) {
            num2freq.put(value, num2freq.getOrDefault(value, 0) + 1);
        }
        return num2freq;
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

    public static ListNode assembleCircle(int[] nums, int joinPointIndex) {
        if (isArrayEmpty(nums)) {
            return null;
        }
        ListNode head = new ListNode(nums[0]), cur = head, joinPoint = null;
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
            if (i == joinPointIndex) {
                joinPoint = cur;
            }
        }
        if (joinPoint != null) {
            cur.next = joinPoint;
        } else if (joinPointIndex == 0) {
            cur.next = head;
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

    /**
     * 根据元素数组还原树
     * @param nums 元素数组
     */
    public static TreeNode assemble(Integer[] nums) {
        return assembleFromLevelOrder(nums);
    }

    /**
     * 根据层序遍历结果数组还原树
     * @param nums 层序遍历结果数组
     */
    public static TreeNode assembleFromLevelOrder(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) {
            return null;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Integer num : nums) {
            treeNodes.add(num == null ? null : new TreeNode(num));
        }
        int depth = 0, l = nums.length, parentLvlStart = 0, parentLvlMax, parentLvlEnd, childrenLvlStart, childrenLvlMax, childrenLvlEnd;
        while (l >= (childrenLvlMax = 1 << (depth + 1))) {
            parentLvlMax = 1 << depth;
            parentLvlEnd = Math.min(parentLvlStart + parentLvlMax - 1, l - 1);
            childrenLvlStart = parentLvlEnd + 1;
            childrenLvlEnd = Math.min(childrenLvlStart + childrenLvlMax - 1, l - 1);
            int idx = 0;
            for (int i = parentLvlStart; i <= parentLvlEnd; i++) {
                TreeNode parent = treeNodes.get(i), child;
                if (parent == null) {
                    continue;
                }
                int lIdx, rIdx;
                if ((lIdx = childrenLvlStart + idx++) <= childrenLvlEnd && Objects.nonNull(child = treeNodes.get(lIdx))) {
                    parent.left = child;
                }
                if ((rIdx = childrenLvlStart + idx++) <= childrenLvlEnd && Objects.nonNull(child = treeNodes.get(rIdx))) {
                    parent.right = child;
                }
            }
            depth++;
            parentLvlStart = childrenLvlStart;
        }
        return treeNodes.get(0);
    }

    /**
     * 按照层序遍历顺序打印树
     */
    public static void printTreeAsLevelOrder(TreeNode root) {
        Solution_102 solution102 = new Solution_102();
        List<List<Integer>> levelOrder = solution102.levelOrder(root);
        System.out.println(levelOrder);
    }

    public static void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0 || i == j || i < 0 || j < 0 || i >= nums.length || j >= nums.length) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static List<List<Integer>> assemble(int[][] board) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] b : board) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int n : b) {
                arrayList.add(n);
            }
            ans.add(arrayList);
        }
        return ans;
    }
}
