package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。</p>
 * <p>如果可以，返回 true ；否则返回 false 。</p>
 *
 * <p>magazine 中的每个字符只能在 ransomNote 中使用一次。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：ransomNote = "a", magazine = "b"
 *     输出：false
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：ransomNote = "aa", magazine = "ab"
 *     输出：false
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：ransomNote = "aa", magazine = "aab"
 *     输出：true
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/ransom-note/">赎金信</a>
 * @since 2023/1/9 10:33
 */
public class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Integer, Integer> ransomNoteIndex = new HashMap<>();
        Map<Integer, Integer> magazineIndex = new HashMap<>();
        mapIndex(ransomNote, ransomNoteIndex);
        mapIndex(magazine, magazineIndex);

        for (Map.Entry<Integer, Integer> e : ransomNoteIndex.entrySet()) {
            if (magazineIndex.getOrDefault(e.getKey(), 0) < e.getValue()) {
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
        String ransomNote = "aa", magazine = "aab";
        Solution_383 solution383 = new Solution_383();
        System.out.println(solution383.canConstruct(ransomNote, magazine));
    }
}
