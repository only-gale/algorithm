package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * <p>给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。</p>
 * <p>返回 已排序的字符串 。如果有多个答案，返回其中任何一个。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>1 <= s.length <= 5 * 10^5</li>
 *     <li>s 由大小写英文字母和数字组成</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/sort-characters-by-frequency/">根据字符出现频率排序</a>
 * @since 2023/2/7 14:27
 */
public class Solution_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> char2freq = new HashMap<>();
        Map<Integer, Set<Character>> freq2char = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char2freq.put(c, char2freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry :char2freq.entrySet()){
            int freq = entry.getValue();
            Set<Character> characters = freq2char.getOrDefault(freq, new HashSet<>());
            if (characters.add(entry.getKey())) {
                freq2char.put(freq, characters);
            }
        }
        int[] freqs = Arrays.stream(freq2char.keySet().toArray(new Integer[0])).mapToInt(n -> n).toArray();
        buildLittleHeap(freqs);
        StringBuilder sb = new StringBuilder();
        for (int freq : freqs) {
            Set<Character> characters = freq2char.get(freq);
            for (char c : characters) {
                append(sb, c, freq);
            }
        }
        return sb.toString();
    }

    private void append(StringBuilder sb, char c, int freq) {
        for (int i = 0; i < freq; i++) {
            sb.append(c);
        }
    }

    private void buildLittleHeap(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    private void buildHeap(int[] nums) {
        int l = nums.length;;
        for (int i = (l >> 1) - 1; i >= 0; i--) {
            heapify(nums, l, i);
        }
    }

    private void heapify(int[] nums, int need2sortNums, int lastParentIdx) {
        int min = lastParentIdx, ldx, rdx;
        while (true) {
            ldx = (lastParentIdx << 1) + 1;
            rdx = ldx + 1;
            if (ldx < need2sortNums && nums[ldx] < nums[min]) {
                min = ldx;
            }
            if (rdx < need2sortNums && nums[rdx] < nums[min]) {
                min = rdx;
            }
            if (min == lastParentIdx) {
                break;
            }
            swap(nums, lastParentIdx, min);
            lastParentIdx = min;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "tree";
        Solution_451 solution451 = new Solution_451();
        System.out.println(solution451.frequencySort(s));
    }
}
