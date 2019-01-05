package org.jerold.leetcode;

import java.util.*;

/**
 * see leetcode https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * <p>
 * Example 4:
 * tmp = 1;
 * start = 4;
 * Input: "abcadeabc"
 * Output: 5
 * Explanation: The answer is "bcade", with the length of 5.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by Jerold on 2018/12/27.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int largest = 0;
        Set<Character> set = new HashSet<>(s.length());
        int start = 0, point = 0;
        while (point < s.length()) {
            if (!set.contains(s.charAt(point))) {
                set.add(s.charAt(point++));
                largest = Math.max(largest, set.size());
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return largest;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int largest = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        int start = 0, point = 0;
        while (start < s.length() && point < s.length()) {
            Integer location = map.get(s.charAt(point));
            if (location != null) {
                int subStrSize = map.keySet().size();
                if (subStrSize > largest) {
                    largest = subStrSize;
                }
                int tmp = start;
                start = location + 1;
                for (int i = tmp; i < start; i++) {
                    map.remove(s.charAt(i));
                }
            }
            map.put(s.charAt(point), point);
            point++;
        }
        int leftStrSize = map.keySet().size();
        if (leftStrSize > largest) {
            largest = leftStrSize;
        }
        return largest;
    }

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring3("abcabcbb");
        int b = lengthOfLongestSubstring3("bbbbb");
        int c = lengthOfLongestSubstring3("pwwkew");
        int d = lengthOfLongestSubstring3("abcadeabcf");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int largest = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int start = 0, point = 0;
        while (start < chars.length && point < chars.length) {
            if (map.get(chars[point]) != null) {
                int subStrSize = map.keySet().size();
                if (subStrSize > largest) {
                    largest = subStrSize;
                }
                int tmp = map.get(chars[point]);
                start = tmp + 1;
                point = start;
                map.clear();
            } else {
                map.put(chars[point], point);
                point++;
            }
        }
        int leftStrSize = map.keySet().size();
        if (leftStrSize > largest) {
            largest = leftStrSize;
        }
        return largest;
    }
}
