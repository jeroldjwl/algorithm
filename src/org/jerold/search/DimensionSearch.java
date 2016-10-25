package org.jerold.search;

/**
 * Created by Jerold on 2016/10/22.
 */
public class DimensionSearch {
    public static void main(String[] args) {
        int[][] origin = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(dimensionSearch(origin, 19));
        System.out.println(dimensionSearch2(origin, 15));
    }

    public static boolean dimensionSearch(int[][] origin, int key) {
        int i, j;
        i = j = 0;
        if (origin != null) {
            while (i < origin.length && j >= 0 && j < origin[i].length) {
                if (origin[i][j] == key)
                    return true;
                else if (origin[i][j] > key || j == origin[i].length - 1) {
                    i++;
                    j--;
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    public static boolean dimensionSearch2(int[][] origin, int key) {
        boolean found = false;
        int row, column;
        if (origin != null) {
            row = 0;
            column = origin[row].length - 1;
            while (row < origin.length && column >= 0) {
                if (origin[row][column] == key) {
                    found = true;
                    break;
                } else if (origin[row][column] > key) {
                    column--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }
}
