package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * <p>示例1</p>
 * <pre>
 *     输入: nums = [1,1,1,2,2,3], k = 2
 *     输出: [1,2]
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/top-k-frequent-elements/">前 K 个高频元素</a>
 * @since 2022/9/5 14:51
 */
public class Solution_347_TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k <= 0) {
            return new int[]{};
        }
        if(k >= len) {
            return nums;
        }
        Map<Integer, Integer> num2freq = new HashMap<>();
        for (int value : nums) {
            num2freq.put(value, num2freq.getOrDefault(value, 0) + 1);
        }
        Map<Integer, List<Integer>> freq2nums = new HashMap<>();
        int[] freqOrder = new int[len + 1];
        for (Map.Entry<Integer, Integer> en : num2freq.entrySet()) {
            int freq = en.getValue();
            int num = en.getKey();
            freqOrder[freq] = freq;
            List<Integer> numsList = freq2nums.getOrDefault(freq, new ArrayList<>());
            numsList.add(num);
            freq2nums.put(freq, numsList);
        }
        int left = k;
        List<Integer> result = new ArrayList<>(k);
        for(int j = len; j > 0; j--) {
            if(left <= 0) {
                break;
            }
            List<Integer> bucket = freq2nums.getOrDefault(freqOrder[j], new ArrayList<>());
            int sz = bucket.size(), addedSize;
            boolean added;
            if(sz == 0) {
                continue;
            }
            if(left >= sz) {
                added = result.addAll(bucket);
                addedSize = bucket.size();
            } else {
                List<Integer> subList = bucket.subList(0, sz - left + 1);
                added = result.addAll(subList);
                addedSize = subList.size();
            }
            if(added) {
                left -= addedSize;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
