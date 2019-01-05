package org.jerold.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Created by Jerold on 2019/1/3.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        String str = convert(s, numRows);
        System.out.println(str);
    }

    private static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.toCharArray().length;
        int h = numRows;
        if (h == 1) {
            return s;
        }
        int lNum = len / (2 * h - 2) + 1;
        int l = lNum * (h - 1);
        char[][] chars = new char[h][l];
        int i = 0;
        for (int k = 0; k < lNum; k++) {
            int m = 0, n = k * (h - 1);
            for (; m < h; m++) {
                if (i < s.length()) {
                    chars[m][n] = s.charAt(i++);
                } else {
                    break;
                }
            }
            if (i < s.length()) {
                m = h - 2;
                n = k * (h - 1) + 1;
                for (; m > 0; m--, n++) {
                    if (i < s.length()) {
                        chars[m][n] = s.charAt(i++);
                    } else {
                        break;
                    }
                }
            }
        }
        char[] result = new char[s.length()];
        int p = 0;
        for (char[] aChar : chars) {
            for (char anAChar : aChar) {
                if (anAChar != 0) {
                    result[p++] = anAChar;
                }
            }
        }
        return String.valueOf(result);
    }
}
