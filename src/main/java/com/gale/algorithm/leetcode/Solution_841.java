package com.gale.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>有 n 个房间，房间按从 0 到 n - 1 编号。</p>
 * <p>最初，除 0 号房间外的其余所有房间都被锁住。</p>
 * <p>你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。</p>
 * <p>当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。</p>
 * <p>给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。</p>
 * <p>如果能进入 所有 房间返回 true，否则返回 false。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>n == rooms.length</li>
 *     <li>2 <= n <= 1000</li>
 *     <li>0 <= rooms[i].length <= 1000</li>
 *     <li>1 <= sum(rooms[i].length) <= 3000</li>
 *     <li>0 <= rooms[i][j] < n</li>
 *     <li>所有 rooms[i] 的值 互不相同</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/keys-and-rooms/">钥匙和房间</a>
 * @since 2023/2/6 16:37
 */
public class Solution_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // 0号房间初始打开
        int[] inDegrees = new int[n - 1];
        List<Integer> keys = new LinkedList<>(rooms.get(0));
        while (!keys.isEmpty()) {
            Integer key = keys.remove(0);
            if (key > 0) {
                if (inDegrees[key - 1] == 0) {
                    keys.addAll(rooms.get(key));
                }
                inDegrees[key - 1] += 1;
            }
        }
        for (int inDegree : inDegrees) {
            if (inDegree == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1},{2},{3},{0}};
//        int[][] nums = {{1,3},{3,0,1},{2},{0}};
        List<List<Integer>> rooms = Util.assemble(nums);
        Solution_841 solution841 = new Solution_841();
        System.out.println(solution841.canVisitAllRooms(rooms));
    }
}
