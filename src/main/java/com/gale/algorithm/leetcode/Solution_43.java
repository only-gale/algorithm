package com.gale.algorithm.leetcode;

/**
 * <p>给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。</p>
 * <p>注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。</p>
 * <br>
 *
 * <p>示例 1:</p>
 * <pre>
 *     输入: num1 = "2", num2 = "3"
 *     输出: "6"
 * </pre>
 *
 * <p>示例 2:</p>
 * <pre>
 *     输入: num1 = "123", num2 = "456"
 *     输出: "56088"
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= num1.length, num2.length <= 200</li>
 *     <li>num1 和 num2 只能由数字组成。</li>
 *     <li>num1 和 num2 都不包含任何前导零，除了数字0本身。</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/multiply-strings/">字符串相乘</a>
 * @since 2023/1/30 11:10
 */
public class Solution_43 {

    /**
     * 使用乘法
     *
     * @see <a href="https://leetcode.cn/problems/multiply-strings/solution/zi-fu-chuan-xiang-cheng-by-leetcode-solution/">官方解法</a>
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length(), l2 = num2.length(), ii, ij, tmp;
        // 结果数组
        int[] ansArr = new int[l1 + l2];

        for (int i = l1 - 1; i >= 0; i--) {
            ii = num1.charAt(i) - '0';
            if (ii == 0) {
                continue;
            }
            for (int j = l2 - 1; j >= 0; j--) {
                ij = num2.charAt(j) - '0';
                tmp = ii * ij;
                if ((ansArr[i + j + 1] += tmp) >= 10) {
                    ansArr[i + j] += ansArr[i + j + 1] / 10;
                    ansArr[i + j + 1] = ansArr[i + j + 1] % 10;
                }
            }
        }
        // 结果字符串
        StringBuilder ans = new StringBuilder();
        // 清除前导0
        for (int i = ansArr[0] == 0 ? 1 : 0; i < ansArr.length; i++) {
            ans.append(ansArr[i]);
        }
        return ans.toString();
    }

    public String multiply_string(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return multiply(num2, num1);
        }
        Solution_415 solution415 = new Solution_415();
        StringBuilder ans = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int ii = Integer.parseInt(String.valueOf(num2.charAt(i)));
            for (int j = num1.length() - 1; j >= 0; j--) {
                int ij = Integer.parseInt(String.valueOf(num1.charAt(j)));

                if (ans.length() == 0) {
                    ans.append(ii * ij);
                } else {
                    StringBuilder tmp = new StringBuilder();
                    int offset = num2.length() - 1 - i + num1.length() - 1 - j;
                    for (int k = 0; k < offset; k++) {
                        tmp.append(0);
                    }
                    tmp.insert(0, ii * ij);
                    ans = new StringBuilder(solution415.addStrings(ans.toString(), tmp.toString()));
                }
            }
        }
        // 清除前导0
        while (ans.lastIndexOf("0", 0) != -1 && ans.length() > 1) {
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "7967", num2 = "7067";
        Solution_43 solution43 = new Solution_43();
        System.out.println(solution43.multiply(num1, num2));
    }
}
