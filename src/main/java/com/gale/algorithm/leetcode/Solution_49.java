package com.gale.algorithm.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。</p>
 * <p>字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 *     输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: strs = [""]
 *     输出: [[""]]
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 *     输入: strs = ["a"]
 *     输出: [["a"]]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= strs.length <= 10^4</li>
 *     <li>0 <= strs[i].length <= 100</li>
 *     <li>strs[i] 仅包含小写字母</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/group-anagrams/">字母异位词分组</a>
 * @since 2023/1/30 09:59
 */
public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 1) {
            ans.add(new ArrayList<String>(){{add(strs[0]);}});
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] alphabets = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alphabets[(char)(str.charAt(i) - 'a')]++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (alphabets[i] != 0) {
                    key.append((char)(i + 'a')).append(alphabets[i]);
                }
            }
            List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
            list.add(str);
            map.put(key.toString(), list);
        }
        ans.addAll(map.values());
        return ans;
    }

    public List<List<String>> groupAnagrams_loop(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 1) {
            ans.add(new ArrayList<String>(){{add(strs[0]);}});
            return ans;
        }

        Map<String, Map<Character, Integer>> indexCache = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            ArrayList<String> list = new ArrayList<>();
            list.add(strs[i]);
            ans.add(list);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == null) {
                    continue;
                }
                if (isAnagram(strs[i], strs[j], indexCache)) {
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            strs[i] = null;
        }
        return ans;
    }

    /**
     * 判断是否异位词
     */
    public boolean isAnagram(String a, String b, Map<String, Map<Character, Integer>> indexCache) {
        if (a == null || b == null) {
            return false;
        }
        // 长度不一致则不是异位词
        if (a.length() != b.length()) {
            return false;
        }
        // 空字符串是异位词
        if (a.length() == 0 || a.equals(b)) {
            return true;
        }

        // 判断异位词：字母及其个数都相同但顺序不同
        Map<Character, Integer> index;
        if (!indexCache.getOrDefault(a, new HashMap<>()).isEmpty()) {
            index = indexCache.get(a);
            for (int i = 0; i < b.length(); i++) {
                char c2 = b.charAt(i);
                index.put(c2, index.getOrDefault(c2, 0) - 1);
            }
        } else {
            index = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                char c1 = a.charAt(i), c2 = b.charAt(i);
                index.put(c1, index.getOrDefault(c1, 0) + 1);
                index.put(c2, index.getOrDefault(c2, 0) - 1);
            }
        }
        return !index.values().removeIf(v -> v != 0);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution_49 solution49 = new Solution_49();
        Util.printBoard(solution49.groupAnagrams(strs));
    }
}
