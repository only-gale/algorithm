package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_0804 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track, ans);
        return ans;
    }

    private static void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track, ans);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
