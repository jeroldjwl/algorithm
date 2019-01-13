package org.jerold.leetcode;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * <p>
 * Created by Jerold on 2019/1/13.
 */
public class FlipImage {
    public static void main(String[] args) {
        /**
         * 1, 1, 0,
         * 1, 0, 1,
         * 0, 0, 0,
         *
         * 1, 0, 0,
         * 0, 1, 0,
         * 1, 1, 1,
         */
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + ",");
            }
            System.out.println();
        }
    }

    private static int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        for (int[] aA : A) {
            flipAndInvert(aA);
        }
        return A;
    }

    private static void flipAndInvert(int[] original) {
        int l = 0, r = original.length - 1;
        while ((l < r)) {
            int tmp = original[l];
            original[l] = original[r];
            original[r] = tmp;
            l++;
            r--;
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] == 0) {
                original[i] = 1;
            } else {
                original[i] = 0;
            }
        }
    }
}
