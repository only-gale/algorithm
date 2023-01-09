package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。</p>
 * <p>注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。</p>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入: s = "anagram", t = "nagaram"
 *     输出: true
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: s = "rat", t = "car"
 *     输出: false
 * </pre>
 *
 * <p>提示:</p>
 * <ul>
 *     <li>1 <= s.length, t.length <= 5 * 10^4</li>
 *     <li>s 和 t 仅包含小写字母</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/valid-anagram/">有效的字母异位词</a>
 * @since 2023/1/9 10:46
 */
public class Solution_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Integer, Integer> sIndex = new HashMap<>();
        Map<Integer, Integer> tIndex = new HashMap<>();
        mapIndex(s, sIndex);
        mapIndex(t, tIndex);

        for (Map.Entry<Integer, Integer> e : sIndex.entrySet()) {
            if (!Objects.equals(tIndex.getOrDefault(e.getKey(), 0), e.getValue())) {
                return false;
            }
        }
        return true;
    }

    public void mapIndex(String s, Map<Integer, Integer> index) {
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            index.put(c, index.getOrDefault(c, 0) + 1);
        }
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Solution_242 solution242 = new Solution_242();
        System.out.println(solution242.isAnagram(s, t));
    }
}
