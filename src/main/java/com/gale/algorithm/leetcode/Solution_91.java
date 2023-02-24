package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：</p>
 * <pre>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * </pre>
 * <p>要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：</p>
 * <ul>
 *     <li>"AAJF" ，将消息分组为 (1 1 10 6)</li>
 *     <li>"KJF" ，将消息分组为 (11 10 6)</li>
 * </ul>
 * <p>注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。</p>
 * <p>给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。</p>
 * <p>题目数据保证答案肯定是一个 32 位 的整数。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= s.length <= 100</li>
 *     <li>s 只包含数字，并且可能包含前导零。</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/decode-ways/">解码方法</a>
 * @since 2023/2/23 16:39
 */
public class Solution_91 {
    public int numDecodings(String s) {
        Map<String, String> map = new HashMap<String, String>(){{
            put("1", "A");
            put("2", "B");
            put("3", "C");
            put("4", "D");
            put("5", "E");
            put("6", "F");
            put("7", "G");
            put("8", "H");
            put("9", "I");
            put("10", "J");
            put("11", "K");
            put("12", "L");
            put("13", "M");
            put("14", "N");
            put("15", "O");
            put("16", "P");
            put("17", "Q");
            put("18", "R");
            put("19", "S");
            put("20", "T");
            put("21", "U");
            put("22", "V");
            put("23", "W");
            put("24", "X");
            put("25", "Y");
            put("26", "Z");
        }};
        // dp[i] 只和 dp[i - 1]、dp[i - 2]有关
        // dp2 = dp[i - 2]
        // dp1 = dp[i - 1]
        int len = s.length(), dp2 = 0, dp1 = 1, ans = 0;
        for (int i = 1; i <= len; i++) {
            ans = 0;
            if (map.containsKey(s.substring(i - 1, i))) {
                ans += dp1;
            }
            if (i >= 2 && map.containsKey(s.substring(i - 2, i))) {
                ans += dp2;
            }
            dp2 = dp1;
            dp1 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "11206";
        Solution_91 solution91 = new Solution_91();
        System.out.println(solution91.numDecodings(s));
    }
}
