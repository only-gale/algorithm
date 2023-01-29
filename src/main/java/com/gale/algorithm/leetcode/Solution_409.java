package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。</p>
 * <p>在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入:s = "abccccdd"
 *     输出:7
 *     解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入:s = "a"
 *     输入:1
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入:s = "aaaaaccc"
 *     输入:7
 * </pre>
 *
 * 提示:
 * <ul>
 *     <li>1 <= s.length <= 2000</li>
 *     <li>s 只由小写 和/或 大写英文字母组成</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/longest-palindrome/">最长回文串</a>
 * @since 2023/1/29 16:56
 */
public class Solution_409 {

    /**
     * 可以组成的最长回文串，肯定包括了所有出现次数为偶数的字符，以及最长的奇数次字符，再加上大于1次且非最长奇数次的字符（这部分使用它们的偶数次）
     */
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index.put(c, index.getOrDefault(c, 0) + 1);
        }

        int ans = 0, maxOdd = 0;
        for (Map.Entry<Character, Integer> e : index.entrySet()) {
            int times = e.getValue();
            if ((times & 1) == 1) {         // 奇数次
                if (times > maxOdd) {       // 新的最长奇数次
                    if (maxOdd > 1) {       // 原来的最长奇数次将变为非最长，所以当原来的最长大于1次时，也将它变为偶数次使用
                        ans += maxOdd - 1;
                    }
                    maxOdd = times;
                } else if (times > 1) {     // 大于1次且非最长奇数次，将它们变成偶数次使用
                    ans += times - 1;
                }
            } else {                        // 偶数次
                ans += times;
            }
        }
        return ans + maxOdd;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        Solution_409 solution409 = new Solution_409();
        System.out.println(solution409.longestPalindrome(s));
    }
}
