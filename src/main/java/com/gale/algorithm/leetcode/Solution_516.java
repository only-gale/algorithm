package com.gale.algorithm.leetcode;

/**
 * <p>给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。</p>
 * <p>子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。</p>
 *
 * <p>示例1</p>
 * <pre>
 *     输入：s = "bbbab"
 *     输出：4
 *     解释：一个可能的最长回文子序列为 "bbbb" 。
 * </pre>
 *
 * <p>示例2</p>
 * <pre>
 *     输入：s = "cbbd"
 *     输出：2
 *     解释：一个可能的最长回文子序列为 "bb" 。
 * </pre>
 * @see <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/">最长回文子序列</a>
 */
public class Solution_516 {
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = 1;
        }
        for (int i = l - 2; i >= 0 ; i--) {
            for (int j = i + 1; j < l; j++) {
                char si = s.charAt(i);
                char sj = s.charAt(j);
                if (si == sj) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][l-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindrome(s));
    }
}
