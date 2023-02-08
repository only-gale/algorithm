package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * <p>给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= nums.length <= 10^5</li>
 *     <li>k 的取值范围是 [1, 数组中不相同的元素的个数]</li>
 *     <li>题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/top-k-frequent-elements/">前 K 个高频元素</a>
 * @since 2023/2/7 10:24
 */
public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < 2) {
            return nums;
        }
        // 数字1 -> 频率1
        Map<Integer, Integer> num2freq = new HashMap<>();
        // 频率1 -> 数字n
        Map<Integer, List<Integer>> freq2num = new HashMap<>();
        // 组装
        for (int n : nums) {
            num2freq.put(n, num2freq.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : num2freq.entrySet()) {
            List<Integer> freq = freq2num.getOrDefault(e.getValue(), new ArrayList<>());
            freq.add(e.getKey());
            freq2num.put(e.getValue(), freq);
        }
        int[] freqs = Arrays.stream(freq2num.keySet().toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        // 构建k次大顶堆
        buildBiggerHeap(freqs, k);
        int left = k;
        List<Integer> ans = new ArrayList<>();
        for (int i = freqs.length - 1; i >= Math.max(freqs.length - k, 0) && left > 0; i--) {
            List<Integer> integers = freq2num.get(freqs[i]);
            int limit = Math.min(left, integers.size());
            ans.addAll(integers.subList(0, limit));
            left -= limit;
        }
        return ans.stream().mapToInt(n -> n).toArray();
    }

    /**
     * 构建大顶堆
     * @param nums 堆排序数组
     * @param k    只构建k次
     */
    private void buildBiggerHeap(int[] nums, int k) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= Math.max(nums.length - k, 0); i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    private void buildHeap(int[] nums) {
        int l = nums.length;
        for (int i = (l >> 1) - 1; i >= 0; i--) {
            heapify(nums, l, i);
        }
    }

    private void heapify(int[] nums, int need2sorted, int lastParentIdx) {
        int need2swap = lastParentIdx, ldx, rdx;
        while (true) {
            ldx = (lastParentIdx << 1) + 1;
            rdx = ldx + 1;
            if (ldx < need2sorted && nums[ldx] > nums[need2swap]) {
                need2swap = ldx;
            }
            if (rdx < need2sorted && nums[rdx] > nums[need2swap]) {
                need2swap = rdx;
            }
            if (need2swap == lastParentIdx) {
                break;
            }
            swap(nums, lastParentIdx, need2swap);
            lastParentIdx = need2swap;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Solution_347 solution347 = new Solution_347();
        nums = solution347.topKFrequent(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
