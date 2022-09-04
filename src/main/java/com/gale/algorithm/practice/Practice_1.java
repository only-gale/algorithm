package com.gale.algorithm.practice;

import java.util.Arrays;

/**
 * 给定一个长度为n的01串，找到两个最长区间，使得这两个区间中，1的个数相等，0的个数也相等。这两个区间可以相交，但不可以完全重叠。
 */
public class Practice_1 {
    public static boolean isMatch(String s1, String s2) {
        int[] nums1 = getNums(s1);
        int[] nums2 = getNums(s2);
        return nums1[0] == nums2[0] && nums1[1] == nums2[1];
    }

    public static int[] getNums(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if ("0".equals(c)) {
                res[0] += 1;
            } else if ("1".equals(c)) {
                res[1] += 1;
            }
        }
        return res;
    }

    public static int[] solution(String s, int pad) {
        int l = s.length();
        int i = 0, j = 1;
        int[] res = new int[3];
        if (pad > 0) {
            while (i + pad <= l - 1) {
                while (j + pad <= l) {
                    if (isMatch(s.substring(i, i + pad), s.substring(j, j + pad))) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = pad;
                        return res;
                    }
                    j++;
                }
                i++;
            }
            res = solution(s, pad - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "1110001";
        int max = s.length() - 1;
        System.out.println(Arrays.toString(solution(s, max)));
    }
}
