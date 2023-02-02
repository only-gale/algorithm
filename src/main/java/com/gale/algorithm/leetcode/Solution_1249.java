package com.gale.algorithm.leetcode;

import java.util.LinkedList;

/**
 * <p>给你一个由 '('、')' 和小写字母组成的字符串 s。</p>
 * <p>你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。</p>
 * <p>请返回任意一个合法字符串。</p>
 * <p>有效「括号字符串」应当符合以下 任意一条 要求：</p>
 * <ul>
 *     <li>空字符串或只包含小写字母的字符串</li>
 *     <li>可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」</li>
 *     <li>可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」</li>
 * </ul>
 * <br>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：s = "lee(t(c)o)de)"
 *     输出："lee(t(c)o)de"
 *     解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：s = "a)b(c)d"
 *     输出："ab(c)d"
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：s = "))(("
 *     输出：""
 *     解释：空字符串也是有效的
 * </pre>
 *
 * 提示：
 * <ul>
 *     <li>1 <= s.length <= 105</li>
 *     <li>s[i] 可能是 '('、')' 或英文小写字母</li>
 * </ul>
 *
 * @see <a href="https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/">移除无效的括号</a>
 * @since 2023/2/1 09:35
 */
public class Solution_1249 {
    public String minRemoveToMakeValid(String s) {
        byte[] bytes = s.getBytes();
        // 判断括号有效性
        LinkedList<Integer> stack = new LinkedList<>();
        // 存储可能的后置'('
        LinkedList<Integer> suspect = new LinkedList<>();
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (c == ')') {
                if (!stack.isEmpty() && stack.getFirst() == '(') {
                    stack.pop();
                    // 括号有效，删除后置的'('可疑性
                    suspect.pop();
                } else {
                    // 前导的)直接删除
                    bytes[i] = 32;
                }
            } else if (c == '(') {
                if (stack.isEmpty() || stack.getFirst() == '(') {
                    stack.push((int) c);
                    suspect.push(i);
                }
            }
        }
        if (!stack.isEmpty()) {
            suspect.forEach(i -> bytes[i] = 32);
        }
        String ans = new String(bytes);
        return ans.replaceAll(" ", "");
    }

    public static void main(String[] args) {
        String s = "())()(((";
        Solution_1249 solution1249 = new Solution_1249();
        System.out.println(solution1249.minRemoveToMakeValid(s));
    }
}
