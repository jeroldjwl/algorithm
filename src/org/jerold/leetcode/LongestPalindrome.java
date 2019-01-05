package org.jerold.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * Example 3:
 * <p>
 * Input: "babbd"
 * Output: "bab"
 * <p>
 * Example 4:
 * Input: "abbfff"
 * Output: "fff"
 * Created by Jerold on 2018/12/28.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String ret1 = longestPalindrome("babad");
        String ret2 = longestPalindrome("cbbd");
        String ret3 = longestPalindrome("babbd");
        String ret4 = longestPalindrome("abbfff");
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
        System.out.println(ret4);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int i, j;
        int max = 0;
        int start = 0;
        int end = 0;
        for (i = 0; i < s.length(); i++) {
            j = i + 1;
            while (j < s.length()) {
                if (isPalindrome(s, i, j)) {
                    max = Math.max(max, j - i);
                }
                j++;
            }
        }

        return s.substring(start, end + 1);
    }

    private static boolean isPalindrome(String s, int start, int end) {
        int left, right;
        if ((end - start) % 2 == 0) {
            left = right = (end + start) / 2;
        } else {
            left = (end + start) / 2;
            right = left + 1;
        }
        while (left >= start && right <= end) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
