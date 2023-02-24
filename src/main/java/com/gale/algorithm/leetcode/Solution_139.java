package com.gale.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。</p>
 * <p>注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *     注意，你可以重复使用字典中的单词。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= s.length <= 300</li>
 *     <li>1 <= wordDict.length <= 1000</li>
 *     <li>1 <= wordDict[i].length <= 20</li>
 *     <li>s 和 wordDict[i] 仅有小写英文字母组成</li>
 *     <li>wordDict 中的所有字符串 互不相同</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/word-break/">单词拆分</a>
 * @since 2023/2/20 10:26
 */
public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        String[] words = {"apple", "pen"};
        List<String> wordDict = Arrays.asList(words);
        Solution_139 solution139 = new Solution_139();
        System.out.println(solution139.wordBreak(s, wordDict));
    }
}
