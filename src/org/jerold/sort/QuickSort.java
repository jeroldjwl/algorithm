package org.jerold.sort;

/**
 * Created by Jerold on 2017/4/11.
 */
public class QuickSort {
    public void quickSort(int[] src, int start, int end) {
        if (start <= end) {
            int pos = partition(src, start, end);
            quickSort(src, start, pos - 1);
            quickSort(src, pos + 1, end);
        }
    }

    private int partition(int[] src, int start, int end) {
        int flagNum = src[start];
        while (start < end) {
            while (start < end && src[end] > flagNum)
                end--;
            src[start] = src[end];
            while (start < end && src[start] <= flagNum)
                start++;
            src[end] = src[start];
        }
        src[start] = flagNum;
        return start;
    }

    public static void main(String[] args) {
        int[] src = new int[]{3, 1, 5, 2, 2, 6, 8, 9, 7, 4, -1, 10, 9, 8, 9};
        QuickSort qs = new QuickSort();
        qs.quickSort(src, 0, src.length - 1);
        for (int i : src)
            System.out.print(i + ", ");
    }
}
