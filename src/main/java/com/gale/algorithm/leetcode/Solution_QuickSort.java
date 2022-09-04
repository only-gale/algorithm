package com.gale.algorithm.leetcode;

import java.util.Arrays;

public class Solution_QuickSort {
    public static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        int key = nums[lo];

        while (i <= gt) {
            if (nums[i] == key) {
                i++;
            } else if (nums[i] < key) {
                exch(nums, lt++, i++);
            } else {
                exch(nums, i, gt--);
            }
        }

        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 9, 8, 7, 6, 1, 3, 20, 22};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
