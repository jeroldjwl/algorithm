package org.jerold.sort;

/**
 * Created by jerold on 2017/4/27.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] src = new int[]{4, 1, 3, 6, 7, 2, 9, 8, 0, 5, 5, 5};
        src = selectSort(src);
        for (int i : src) {
            System.out.print(i + ", ");
        }
    }

    public static int[] selectSort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            int min = src[i];
            int seq = i;
            for (int j = i; j < src.length; j++) {
                if (src[j] < min) {
                    min = src[j];
                    seq = j;
                }
            }
            int tmp = src[i];
            src[i] = src[seq];
            src[seq] = tmp;
        }
        return src;
    }
}
