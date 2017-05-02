package org.jerold.sort;

/**
 * Created by jerold on 2017/4/27.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] src = new int[]{4, 1, 3, 6, 7, 2, 9, 8, 0, 5, 5, 5, 9, 10, 8, 17, 24};
        mergeSort(src, new int[src.length], 0, src.length - 1);
        for (int i : src) {
            System.out.print(i + ", ");
        }
    }

    public static void mergeSort(int[] src, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSort(src, tmp, start, mid);
            mergeSort(src, tmp, mid + 1, end);
            int i = start;
            int j = mid + 1;
            int k = 0;
            while (i <= mid && j <= end) {
                if (src[i] < src[j]) {
                    tmp[k++] = src[i++];
                } else {
                    tmp[k++] = src[j++];
                }
            }
            while (i <= mid) {
                tmp[k++] = src[i++];
            }
            while (j <= end) {
                tmp[k++] = src[j++];
            }
            for (i = 0; i < k; ++i) {
                src[start++] = tmp[i];
            }
        }
    }
}
