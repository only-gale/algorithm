package com.gale.algorithm.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * <p>示例1</p>
 * <pre>
 *     输入：s = "babad"
 *     输出："bab"
 *     解释："aba" 同样是符合题意的答案。
 * </pre>
 *
 * <p>示例2</p>
 * <pre>
 *     输入：s = "cbbd"
 *     输出："bb"
 * </pre>
 */
public class Solution_5 {
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private static String palindrome(String s, int l, int r) {
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l+1, r);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
