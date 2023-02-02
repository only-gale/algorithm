package com.gale.algorithm.leetcode;

/**
 * <p>共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。</p>
 * <p>确切地说，从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。</p>
 * <br>
 * <p>游戏遵循如下规则：</p>
 * <ol>
 *     <li>从第 1 名小伙伴所在位置 开始 。</li>
 *     <li>沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。</li>
 *     <li>你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。</li>
 *     <li>如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。</li>
 *     <li>否则，圈子中最后一名小伙伴赢得游戏。</li>
 * </ol>
 * <p>给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <img src="docFile/1823_1.png" />
 * <pre>
 * 输入：n = 5, k = 2
 * 输出：3
 * 解释：游戏运行步骤如下：
 * 1) 从小伙伴 1 开始。
 * 2) 顺时针数 2 名小伙伴，也就是小伙伴 1 和 2 。
 * 3) 小伙伴 2 离开圈子。下一次从小伙伴 3 开始。
 * 4) 顺时针数 2 名小伙伴，也就是小伙伴 3 和 4 。
 * 5) 小伙伴 4 离开圈子。下一次从小伙伴 5 开始。
 * 6) 顺时针数 2 名小伙伴，也就是小伙伴 5 和 1 。
 * 7) 小伙伴 1 离开圈子。下一次从小伙伴 3 开始。
 * 8) 顺时针数 2 名小伙伴，也就是小伙伴 3 和 5 。
 * 9) 小伙伴 5 离开圈子。只剩下小伙伴 3 。所以小伙伴 3 是游戏的获胜者。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：n = 6, k = 5
 *     输出：1
 *     解释：小伙伴离开圈子的顺序：5、4、6、2、3 。小伙伴 1 是游戏的获胜者。
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= k <= n <= 500</li>
 * </ul>
 *
 * 进阶：你能否使用线性时间复杂度和常数空间复杂度解决此问题？
 *
 * @see <a href="https://leetcode.cn/problems/find-the-winner-of-the-circular-game/">找出游戏的获胜者</a>
 * @since 2023/2/2 10:00
 */
public class Solution_1823 {
    public int findTheWinner(int n, int k) {
        int loser = 0, start = 0;
        int[] players = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = i + 1;
        }
        while (loser != n - 1) {
            // 找有效的开始位置start
            while (players[start % n] == 0) {
                start++;
            }
            // 需要从start向前走有效的k-1步
            int steps = k - 1, idx = start;
            while (steps > 0) {
                // 向前走一步
                steps--;

                // 保证向前走的一步有效
                while (players[(idx + 1) % n] == 0) {
                    idx++;
                }
                idx++;
            }
            // 找到本轮失败者
            players[idx % n] = 0;
            loser++;
            // 重置下一轮的开始位置
            start = idx + 1;
        }
        // 已经找到所有n-1位失败者，寻找成功者
        for (int i = 0; i < n; i++) {
            if (players[i] != 0) {
                return players[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        Solution_1823 solution1823 = new Solution_1823();
        System.out.println(solution1823.findTheWinner(n, k));
    }
}
