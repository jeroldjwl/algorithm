package org.jerold.search;

/**
 * Created by Jerold on 2017/4/10.
 */
public class BinarySearch {
    public boolean binarySearch(int[] src, int key, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            if (key == src[mid])
                return true;
            if (key < src[mid])
                return binarySearch(src, key, start, mid - 1);
            else
                return binarySearch(src, key, mid + 1, end);
        }
        return false;
    }

    public boolean binarySearchNonRecursive(int[] src, int key, int start, int end) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (key == src[mid])
                return true;
            if (key < src[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] src = new int[]{3, 1, 5, 7, 6};
        BinarySearch bs = new BinarySearch();
        boolean ret = bs.binarySearch(src, 9, 0, src.length - 1);
        System.out.println(ret);
        ret = bs.binarySearchNonRecursive(src, 0, 0, src.length - 1);
        System.out.println(ret);
    }
}
