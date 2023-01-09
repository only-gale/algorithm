package com.gale.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。</p>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入: s = "leetcode"
 *     输出: 0
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: s = "loveleetcode"
 *     输出: 2
 * </pre>
 *
 * <p>示例 3:</p>
 * <pre>
 *     输入: s = "aabb"
 *     输出: -1
 * </pre>
 *
 * @see <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/">字符串中的第一个唯一字符</a>
 * @since 2023/1/9 10:03
 */
public class Solution_387 {
    public int firstUniqChar(String s) {
        Set<Integer> memo = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!memo.contains((int) c)) {
                boolean found = true;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        found = !memo.add((int) s.charAt(j));
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Solution_387 solution387 = new Solution_387();
        System.out.println(solution387.firstUniqChar(s));
    }
}
