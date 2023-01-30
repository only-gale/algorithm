package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'。</p>
 * <ul>
 *     <li>例如，"ACGAATTCCG" 是一个 DNA序列 。</li>
 * </ul>
 * <p>在研究 DNA 时，识别 DNA 中的重复序列非常有用。</p>
 * <p>给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *     输出：["AAAAACCCCC","CCCCCAAAAA"]
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：s = "AAAAAAAAAAAAA"
 *     输出：["AAAAAAAAAA"]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>0 <= s.length <= 10^5</li>
 *     <li>s[i]=='A'、'C'、'G' or 'T'</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/repeated-dna-sequences/">重复的DNA序列</a>
 * @since 2023/1/30 14:22
 */
public class Solution_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() <= 10) {
            return ans;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, j = 10; j <= s.length();) {
            String ij = s.substring(i++, j++);
            map.put(ij, map.getOrDefault(ij, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                ans.add(e.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        Solution_187 solution187 = new Solution_187();
        System.out.println(solution187.findRepeatedDnaSequences(s));
    }
}
