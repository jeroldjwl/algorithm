package org.jerold.algorithm;

/**
 * Created by Jerold on 2016/11/3.
 */
public class ArrayAlgorithm {
    // 1. 滑动窗口,给定一个已知数组A[]，滑动窗口大小w，输出数组B[]，其中B[i]的值为A[i]到A[i+w-1]之间的最大值。
    public static int[] slideArray(int[] origin, int w) {
        if (origin == null)
            return null;
        int[] result = new int[origin.length - w+1];
        for (int i = 0; i <= origin.length - w; i++) {
            int max = getMaxW(origin, w, i);
            result[i] = max;
        }
        return result;
    }

    private static int getMaxW(int[] origin, int w, int start) {
        int end = start + w - 1;
        int max = origin[start];
        for (int i = start; i <= end; i++) {
            if (origin[i] > max) {
                max = origin[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int[] origin = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ret = slideArray(origin, 3);
        for (int i : ret) {
            System.out.print(i + ", ");
        }
    }
}
