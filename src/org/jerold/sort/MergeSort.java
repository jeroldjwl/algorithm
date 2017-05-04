package org.jerold.sort;

/**
 * Created by Jerold on 2017/4/8.
 */
public class MergeSort {

    public static void mergeSort(int[] src, int[] ret, int start, int end) {
        if (start >= end)
            return;
        int len = end - start;
        int start1 = start;
        int end1 = start + len / 2;
        int start2 = end1 + 1;
        int end2 = end;
        mergeSort(src, ret, start1, end1);
        mergeSort(src, ret, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            ret[k++] = src[start1] < src[start2] ? src[start1++] : src[start2++];
        }
        while (start1 <= end1) {
            ret[k++] = src[start1++];
        }
        while (start2 <= end2) {
            ret[k++] = src[start2++];
        }
        for (k = start; k <= end; k++) {
            src[k] = ret[k];
        }
    }

    public static void mergeSort1(int[] src, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSort1(src, start, mid);
            mergeSort1(src, mid + 1, end);
            merge(src, start, mid, end);
        }
    }

    private static void merge(int[] src, int start, int mid, int end) {
        int end1 = mid;
        int start2 = mid + 1;
        int low = start;
        int[] tmp = new int[end - start + 1];
        int k = 0;
        while (start <= end1 && start2 <= end) {
            tmp[k++] = src[start] < src[start2] ? src[start++] : src[start2++];
        }
        while (start <= end1)
            tmp[k++] = src[start++];
        while (start2 <= end)
            tmp[k++] = src[start2++];
        for (int i = 0; i < tmp.length; i++) {
            src[low + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] src = new int[]{3, 5, 1, 2, 7, 9, 8, 6, 4};
        int[] ret = new int[src.length];
        /*mergeSort(src, ret, 0, src.length - 1);
        for (int i : src) {
            System.out.print(i + ", ");
        }
        System.out.println();*/
        mergeSort1(src, 0, src.length - 1);
        for (int i : src) {
            System.out.print(i + ", ");
        }
        /*System.out.println();
        for (int i : ret) {
            System.out.print(i + ", ");
        }
        for (int i = 1; i <= 100; i++) {
            System.out.println(i & (i - 1));
        }*/
    }
}
