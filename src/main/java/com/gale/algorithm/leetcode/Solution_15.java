package com.gale.algorithm.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。</p>
 * <p>请你返回所有和为 0 且不重复的三元组。</p>
 * <br>
 * <p>示例 1：</p>
 * <pre>
 *     输入：nums = [-1,0,1,2,-1,-4]
 *     输出：[[-1,-1,2],[-1,0,1]]
 *     解释：
 *     nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 *     nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 *     nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 *     不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 *     注意，输出的顺序和三元组的顺序并不重要。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：nums = [0,1,1]
 *     输出：[]
 *     解释：唯一可能的三元组和不为 0 。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：nums = [0,0,0]
 *     输出：[[0,0,0]]
 *     解释：唯一可能的三元组和为 0 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>3 <= nums.length <= 3000</li>
 *     <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/3sum/">三数之和</a>
 * @since 2023/1/18 10:26
 */
public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        return nSum(nums, 3, 0);
    }

    private List<List<Integer>> nSum(int[] nums, int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < k) {
            return ans;
        }

        if (nums.length == k) {
            List<Integer> combo = new ArrayList<>(k);
            for (int n : nums) {
                combo.add(n);
            }
            if (isSumEqZero(combo)) {
                ans.add(combo);
                return ans;
            }
        } else {
            Arrays.sort(nums);
            ArrayList<Integer> index = new ArrayList<>(nums.length);
            for (int n : nums) {
                index.add(n);
            }
            LinkedList<Integer> combo = new LinkedList<>();
            AtomicInteger trackNum = new AtomicInteger(0);
            backtrack(nums, 0, trackNum, ans, combo, k, target, index);
        }
        return ans;
    }

    private void backtrack(int[] nums, int start, AtomicInteger trackNum, List<List<Integer>> ans, LinkedList<Integer> track, int k, int target, ArrayList<Integer> index) {
        if (k - track.size() == 2) {
            int left = target - trackNum.get();
            for (List<Integer> subset : twoSum(nums, left, start)) {
                ArrayList<Integer> combo = new ArrayList<>(track);
                combo.addAll(subset);
                ans.add(combo);
            }
//            if (start < nums.length - 2) {
//                Set<Integer> pool = new HashSet<>(index.subList(start, index.size()));
//                if (pool.contains(left)) {
//                    track.add(left);
//                    ans.add(new ArrayList<>(track));
//                    track.removeLast();
//                }
//            } else if (start == nums.length - 2 && (left & nums[start + 1]) == 0) {
//                track.add(left);
//                ans.add(new ArrayList<>(track));
//                track.removeLast();
//            }
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && (nums[i - 1] ^ nums[i]) == 0) {
                    continue;
                }
                track.add(nums[i]);
                trackNum.getAndAdd(nums[i]);
                backtrack(nums, i + 1, trackNum, ans, track, k, target, index);
                track.removeLast();
                trackNum.set(trackNum.get() - nums[i]);
            }
        }
    }

    private boolean isSumEqZero(List<Integer> combo) {
        int sum = 0;
        for (int n : combo) {
            sum += n;
        }
        return sum == 0;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }

    private boolean isValidCombo(List<List<Integer>> ans, ArrayList<Integer> combo) {
        if (ans.isEmpty()) {
            return true;
        }
        for (List<Integer> usedCombo : ans) {
            boolean same = true;
            ArrayList<Integer> tmp = new ArrayList<>(combo);
            for (Integer used : usedCombo) {
                same = tmp.remove(used);
                if (!same) {
                    break;
                }
            }
            if (same) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution_15 solution15 = new Solution_15();
        System.out.println(solution15.threeSum(nums));
    }
}
