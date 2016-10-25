package org.jerold.sort;

/**
 * Created by Jerold on 16/10/22.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] origin = new int[]{2, 5, 1, 6, 3, 7, 4, 9, 8};
        int[] ret = insertSort(origin);
        for (int i : ret) {
            System.out.print(i + ", ");
        }
        System.out.println();
        ret = insertSort2(origin);
        for (int i : ret) {
            System.out.print(i + ", ");
        }
    }

    public static int[] insertSort(int[] origin) {
        int[] ret = new int[origin.length + 1];
        for (int i = 0; i < origin.length; i++) {
            int tmp = origin[i];
            int p = i - 1;
            while (p >= 0) {
                if (ret[p] > tmp) {
                    ret[p + 1] = ret[p];
                    p--;
                } else {
                    ret[p + 1] = tmp;
                    break;
                }
            }
            if (p < 0) {
                ret[0] = tmp;
            }
        }
        return ret;
    }

    public static int[] insertSort2(int[] origin) {
        for (int i = 0; i < origin.length; i++) {
            int tmp = origin[i];
            int p = i - 1;
            while (p >= 0 && origin[p] > tmp) {
                origin[p + 1] = origin[p];
                p--;
            }
            origin[p + 1] = tmp;
        }
        return origin;
    }
}
