package com.gale.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。</p>
 *
 * 有效字符串需满足：
 * <ol>
 *     <li>左括号必须用相同类型的右括号闭合。</li>
 *     <li>左括号必须以正确的顺序闭合。</li>
 *     <li>每个右括号都有一个对应的相同类型的左括号。</li>
 * </ol>
 *
 * <p>示例 1：</p>
 * <pre>
 *     输入：s = "()"
 *     输出：true
 * </pre>
 *
 * <p>示例 2：</p>
 * <pre>
 *     输入：s = "()[]{}"
 *     输出：true
 * </pre>
 *
 * <p>示例 3：</p>
 * <pre>
 *     输入：s = "(]"
 *     输出：false
 * </pre>
 * @see <a href="https://leetcode.cn/problems/valid-parentheses/">有效的括号</a>
 * @since 2023/1/12 09:37
 */
public class Solution_20 {
    public boolean isValid(String s) {
        Map<Character, Character> index = new HashMap<>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty() || index.get(stack.lastElement()) != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        Solution_20 solution20 = new Solution_20();
        System.out.println(solution20.isValid(s));
    }
}
