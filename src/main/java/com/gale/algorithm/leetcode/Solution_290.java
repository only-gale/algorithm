package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。</p>
 * <p>这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。</p>
 * <br>
 *
 * <p>示例1:</p>
 * <pre>
 *     输入: pattern = "abba", s = "dog cat cat dog"
 *     输出: true
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入:pattern = "abba", s = "dog cat cat fish"
 *     输出: false
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 *     输入: pattern = "aaaa", s = "dog cat cat dog"
 *     输出: false
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>1 <= pattern.length <= 300</li>
 *     <li>pattern 只包含小写英文字母</li>
 *     <li>1 <= s.length <= 3000</li>
 *     <li>s 只包含小写英文字母和 ' '</li>
 *     <li>s 不包含 任何前导或尾随对空格</li>
 *     <li>s 中每个单词都被 单个空格 分隔</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/word-pattern/">单词规律</a>
 * @since 2023/1/29 17:36
 */
public class Solution_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        Map<Character, String> char2word = new HashMap<>();
        Map<String, Character> word2char = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if ((char2word.containsKey(c) && !char2word.get(c).equals(split[i])) || (word2char.containsKey(split[i]) && word2char.get(split[i]) != c)) {
                return false;
            }
            if (!char2word.containsKey(c)) {
                char2word.put(c, split[i]);
                word2char.put(split[i], c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abc", s = "dog cat dog";
        Solution_290 solution290 = new Solution_290();
        System.out.println(solution290.wordPattern(pattern, s));
    }
}
