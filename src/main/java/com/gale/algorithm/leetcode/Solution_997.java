package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <p>小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。</p>
 * <p>如果小镇法官真的存在，那么：</p>
 * <ol>
 *     <li>小镇法官不会信任任何人。</li>
 *     <li>每个人（除了小镇法官）都信任这位小镇法官。</li>
 *     <li>只有一个人同时满足属性 1 和属性 2 。</li>
 * </ol>
 * <p>给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。</p>
 * <p>如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= n <= 1000</li>
 *     <li>0 <= trust.length <= 10^4</li>
 *     <li>trust[i].length == 2</li>
 *     <li>trust 中的所有trust[i] = [ai, bi] 互不相同</li>
 *     <li>ai != bi</li>
 *     <li>1 <= ai, bi <= n</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/find-the-town-judge/">找到小镇的法官</a>
 * @since 2023/2/6 13:42
 */
public class Solution_997 {
    public int findJudge(int n, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return n == 1 ? n : -1;
        }
        HashMap<Integer, HashSet<Integer>> trusted = new HashMap<>();
        HashSet<Integer> trusters = new HashSet<>();
        for (int[] t : trust) {
            HashSet<Integer> trustedSet = trusted.getOrDefault(t[1], new HashSet<>());
            trustedSet.add(t[0]);
            trusters.add(t[0]);
            trusted.put(t[1], trustedSet);
        }
        Integer judger = -1;
        for (Map.Entry<Integer, HashSet<Integer>> e : trusted.entrySet()) {
            Integer key = e.getKey();
            if (e.getValue().size() == n - 1 && !e.getValue().contains(key) && !trusters.contains(key)) {
                judger = key;
            }
        }
        return judger;
    }

    public static void main(String[] args) {
        int[][] trust = {{1,2}};
        int n = 2;
        Solution_997 solution997 = new Solution_997();
        System.out.println(solution997.findJudge(n, trust));
    }
}
