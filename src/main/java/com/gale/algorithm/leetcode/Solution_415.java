package com.gale.algorithm.leetcode;

/**
 * <p>给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。</p>
 * <p>你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。</p>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：num1 = "11", num2 = "123"
 *     输出："134"
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：num1 = "456", num2 = "77"
 *     输出："533"
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：num1 = "0", num2 = "0"
 *     输出："0"
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= num1.length, num2.length <= 10^4</li>
 *     <li>num1 和num2 都只包含数字 0-9</li>
 *     <li>num1 和num2 都不包含任何前导零</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/add-strings/">字符串相加</a>
 * @since 2023/1/29 16:21
 */
public class Solution_415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        int l1 = num1.length(), l2 = num2.length(), plus = 0;
        StringBuilder ans = new StringBuilder();
        while (l1 > 0 && l2 > 0) {
            int c1 = Integer.parseInt(String.valueOf(num1.charAt(--l1))), c2 = Integer.parseInt(String.valueOf(num2.charAt(--l2))), sum = c1 + c2 + plus;
            if (sum >= 10) {
                plus = 1;
                ans.insert(0, sum - 10);
            } else {
                plus = 0;
                ans.insert(0, sum);
            }
        }
        if (l1 > 0) {
            if (plus > 0) {
                ans.insert(0, addStrings(num1.substring(0, l1), String.valueOf(plus)));
            } else {
                ans.insert(0, num1.substring(0, l1));
            }
        } else if (plus > 0) {
            ans.insert(0, plus);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "99", num2 = "99";
        Solution_415 solution415 = new Solution_415();
        System.out.println(solution415.addStrings(num1, num2));
    }
}
