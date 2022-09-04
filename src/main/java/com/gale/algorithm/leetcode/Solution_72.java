package com.gale.algorithm.leetcode;

/**
 * <p>给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。</p>
 * <p>你可以对一个单词进行如下三种操作：</p>
 * <ul>
 *     <li>插入一个字符</li>
 *     <li>删除一个字符</li>
 *     <li>替换一个字符</li>
 * </ul>
 *
 * <p>示例1</p>
 * <pre>
 *     输入：word1 = "horse", word2 = "ros"
 *     输出：3
 *     解释：
 *          horse -> rorse (将 'h' 替换为 'r')
 *          rorse -> rose (删除 'r')
 *          rose -> ros (删除 'e')
 * </pre>
 *
 * <p>示例2</p>
 * <pre>
 *     输入：word1 = "intention", word2 = "execution"
 *     输出：5
 *     解释：
 *          intention -> inention (删除 't')
 *          inention -> enention (将 'i' 替换为 'e')
 *          enention -> exention (将 'n' 替换为 'x')
 *          exention -> exection (将 'n' 替换为 'c')
 *          exection -> execution (插入 'u')
 * </pre>
 * @see <a href="https://leetcode.cn/problems/edit-distance/">编辑距离</a>
 */
public class Solution_72 {
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
