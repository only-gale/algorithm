package com.gale.algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。</p>
 * <p>当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。</p>
 * <p>请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。</p>
 * @see <a href="https://leetcode.cn/problems/russian-doll-envelopes/">俄罗斯套娃信封问题</a>
 */
public class Solution_354 {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return Solution_300.lengthOfLIS(heights);
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][] {{5,4}, {6,4}, {6,7}, {2,3}};
        System.out.println(Solution_354.maxEnvelopes(envelopes));
    }
}
