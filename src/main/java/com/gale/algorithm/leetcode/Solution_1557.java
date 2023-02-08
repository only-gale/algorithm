package com.gale.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你一个 有向无环图， n个节点编号为 0到 n-1，以及一个边数组 edges，其中 edges[i] = [fromi, toi]表示一条从点fromi到点toi的有向边。</p>
 * <p>找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。</p>
 * <p>你可以以任意顺序返回这些节点编号。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/1557_1.png" />
 * <pre>
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 * </pre>
 *
 * <p>示例 2：</p>
 * <img src="docFile/1557_2.png" />
 * <pre>
 * 输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * 输出：[0,2,3]
 * 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>2 <= n <= 10^5</li>
 *     <li>1 <= edges.length <= min(10^5, n * (n - 1) / 2)</li>
 *     <li>edges[i].length == 2</li>
 *     <li>0 <= fromi, toi < n</li>
 *     <li>所有点对 (fromi, toi) 互不相同。</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-vertices-to-reach-all-nodes/">可以到达所有点的最少点数目</a>
 * @since 2023/2/6 15:38
 */
public class Solution_1557 {

    /**
     * 入度为0的点
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> zeroInDegree = new ArrayList<>();
        int[] idx = new int[n];
        for (List<Integer> edge : edges) {
            idx[edge.get(1)] += 1;
        }
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] == 0) {
                zeroInDegree.add(i);
            }
        }
        return zeroInDegree;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1},{0,2},{2,5},{3,4},{4,2}};
        int n = 6;
        List<List<Integer>> edges = Util.assemble(nums);
        Solution_1557 solution1557 = new Solution_1557();
        System.out.println(solution1557.findSmallestSetOfVertices(n, edges));
    }
}
