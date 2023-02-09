package com.gale.algorithm.leetcode;

/**
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。</p>
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= n <= 45</li>
 * </ul>
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/">爬楼梯</a>
 * @since 2023/2/9 10:17
 */
public class Solution_70 {
    public int climbStairs(int n) {
        // dp1 指代爬到i - 1阶楼梯的解
        // dp2 指代爬到i - 2阶楼梯的解
        // ans 指代爬到i阶楼梯的解：爬到i解楼梯的一种方案是爬到i-1阶楼梯，另一种方案是爬到i-2阶楼梯，所以ans=dp1+dp2
        int dp1, dp2, ans = 0;
        if (n == 1) {
            return 1;
        }
        dp1 = dp2 = 1;
        for (int i = 2; i <= n; i++) {
            ans = dp1 + dp2;
            dp1 = dp2;
            dp2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        Solution_70 solution70 = new Solution_70();
        System.out.println(solution70.climbStairs(n));
    }
}
