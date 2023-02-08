package com.gale.algorithm.leetcode;

import java.util.*;

/**
 * <p>给定一个数组 points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。</p>
 * <p>这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。</p>
 * <p>你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/973_1.jpg" />
 * <pre>
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= k <= points.length <= 10^4</li>
 *     <li>-10^4 < xi, yi < 10^4</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/k-closest-points-to-origin/">最接近原点的 K 个点</a>
 * @since 2023/2/7 15:14
 */
public class Solution_973 {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, List<Integer>> distance2idx = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int distance = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
            List<Integer> list = distance2idx.getOrDefault(distance, new ArrayList<>());
            list.add(i);
            distance2idx.put(distance, list);
        }
        int[] distances = Arrays.stream(distance2idx.keySet().toArray(new Integer[0])).mapToInt(n -> n).toArray();
        buildLittleHeap(distances, k);
        List<Integer> ans = new ArrayList<>();
        int left = k, limit;
        for (int i = distances.length - 1; i >= distances.length - k; i--) {
            if (left < 1) {
                break;
            }
            List<Integer> idxes = distance2idx.get(distances[i]);
            limit = Math.min(left, idxes.size());
            if (ans.addAll(idxes.subList(0, limit))) {
                left -= limit;
            }
        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = points[ans.get(i)];
        }
        return result;
    }

    private void buildLittleHeap(int[] nums, int k) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= Math.max(nums.length - k, 0); i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    private void buildHeap(int[] nums) {
        int l = nums.length;
        for (int i = (l >> 1) - 1; i >= 0; i--) {
            heapify(nums, l, i);
        }
    }

    private void heapify(int[] nums, int need2sortCount, int lastParentIdx) {
        int min = lastParentIdx, ldx, rdx;
        while (true) {
            ldx = (lastParentIdx << 1) + 1;
            rdx = ldx + 1;
            if (ldx < need2sortCount && nums[ldx] < nums[min]) {
                min = ldx;
            }
            if (rdx < need2sortCount && nums[rdx] < nums[min]) {
                min = rdx;
            }
            if (min == lastParentIdx) {
                break;
            }
            swap(nums, lastParentIdx, min);
            lastParentIdx = min;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        Solution_973 solution973 = new Solution_973();
        Util.printBoard(solution973.kClosest(points, k));
    }
}
