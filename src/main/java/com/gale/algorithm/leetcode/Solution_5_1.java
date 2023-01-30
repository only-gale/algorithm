package com.gale.algorithm.leetcode;

/**
 * @author yaogang@axzo.cn
 * @since 2023/1/30 15:18
 */
public class Solution_5_1 {
    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        String longestPalindrome = "";
        for(int i = 0; i < s.length() - 1; i++) {
            String si = longestPalindrome(s, i, i), sij = longestPalindrome(s, i, i + 1), longer = si.length() > sij.length() ? si : sij;
            if(longer.length() > longestPalindrome.length()) {
                longestPalindrome = longer;
            }
        }
        return longestPalindrome;
    }

    public String longestPalindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String s = "babad";
        Solution_5_1 solution = new Solution_5_1();
        System.out.println(solution.longestPalindrome(s));
    }
}
