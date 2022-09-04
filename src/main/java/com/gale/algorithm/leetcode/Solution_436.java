package com.gale.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。</p>
 * <p>区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。</p>
 * <p>返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1。</p>
 * @see <a href="https://leetcode.cn/problems/find-right-interval/">寻找右区间</a>
 */
public class Solution_436 {
    public static int[] findRightInterval(int[][] intervals) {
        int s = intervals.length;
        if (s < 1) {
            return new int[]{-1};
        }
        int[] starts = new int[s], ends = new int[s];
        Map<Integer, Integer> start2index = new HashMap<>();
        for (int i = 0; i < s; i++) {
            int[] interval = intervals[i];
            int start = interval[0], end = interval[1];
            starts[i] = start;
            ends[i] = end;
            start2index.put(start, i);
        }
        Arrays.sort(starts);

        for (int i = 0; i < ends.length; i++) {
            int end = ends[i];
            if (end > starts[starts.length - 1]) {
                ends[i] = -1;
                continue;
            }
            // 二分查找：在starts中找大于等于end的最小值
            int l = 0, r = starts.length - 1, mid;
            // 标记是否找到相等值
            boolean flag = false;
            while (l <= r) {
                mid = l + ((r - l) >> 1);
                // 由于start各不相同，所以相等即是大于等于end的最小值
                if (starts[mid] == end) {
                    ends[i] = start2index.get(starts[mid]);
                    flag = true;
                    break;
                } else if (starts[mid] < end) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (!flag) {
                ends[i] = start2index.get(starts[l]);
            }
        }
        return ends;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{3,4}, {2,3}, {1,2}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }
}
