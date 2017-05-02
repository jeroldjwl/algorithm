package org.jerold.sort;

/**
 * Created by jerold on 2017/4/27.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] src = new int[]{4, 1, 3, 6, 7, 2, 9, 8, 0, 5, 5, 5};
        src = bubbleSort(src);
        for (int i : src)
            System.out.print(i + ", ");
    }

    public static int[] bubbleSort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length - 1 - i; j++) {
                if (src[j] > src[j + 1] && j < src.length - i) {
                    int tmp = src[j];
                    src[j] = src[j + 1];
                    src[j + 1] = tmp;
                }
            }
        }
        return src;
    }
}
