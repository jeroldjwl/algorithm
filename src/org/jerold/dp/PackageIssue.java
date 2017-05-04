package org.jerold.dp;

/**
 * Created by jerold on 2017/4/14.
 */
public class PackageIssue {
    private int[] volume = new int[]{5, 4, 3};
    private int[] value = new int[]{20, 10, 12};

    public void getMaxVolumn(int target) {
        int[][] d = new int[volume.length][target];
        for (int i = 0; i < volume.length; i++) {
            for (int j = 0; j < target; j++) {
                d[i][j] = i == 0 ? 0 : d[i - 1][j];
                if (i > 0 && j >= volume[i - 1])
                    d[i][j] = Math.max(d[i - 1][j - volume[i - 1]] + value[i - 1], d[i][j]);
            }
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++)
                System.out.print(d[i][j] + ", ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PackageIssue pi = new PackageIssue();
        pi.getMaxVolumn(10);
    }
}
