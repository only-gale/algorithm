package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * <p>示例 1</p>
 * <pre>
 *     输入：n = 4, k = 2
 *     输出：
 *     [
 *       [2,4],
 *       [3,4],
 *       [2,3],
 *       [1,2],
 *       [1,3],
 *       [1,4],
 *     ]
 * </pre>
 */
public class Solution_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return ans;
        }
        ArrayList<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track, ans);
        return ans;
    }

    private static void backtrack(int n, int k, int start, ArrayList<Integer> track, List<List<Integer>> ans) {
        if (k == track.size()) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track, ans);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
