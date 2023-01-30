package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。</p>
 * <p>注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。</p>
 * <p>返回一个表示每个字符串片段的长度的列表。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：s = "ababcbacadefegdehijhklij"
 *     输出：[9,7,8]
 *     解释：
 *     划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 *     每个字母最多出现在一个片段中。
 *     像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：s = "eccbbbbdec"
 *     输出：[10]
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= s.length <= 500</li>
 *     <li>s 仅由小写英文字母组成</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/partition-labels/">划分字母区间</a>
 * @since 2023/1/29 17:56
 */
public class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 1) {
            ans.add(1);
            return ans;
        }
        // i和j指代可分片段的左右索引（j需要大1位）
        int i = 0, j = 1, l = s.length();
        // 滑动j
        while (j <= l) {
            String ij = s.substring(i, j);
            boolean found = false;
            // 倒序查看字符是否在子字符串ij中
            for (int k = l - 1; k >= j; k--) {
                String single = String.valueOf(s.charAt(k));
                // 如果在，则更新j
                if (ij.contains(single)) {
                    found = true;
                    j = k + 1;
                    break;
                }
            }

            // 如果不在，说明当前ij就是可分片段，更新ij继续找下一段
            if (!found) {
                ans.add(j - i);
                i = j;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        Solution_763 solution763 = new Solution_763();
        System.out.println(solution763.partitionLabels(s));
    }
}
