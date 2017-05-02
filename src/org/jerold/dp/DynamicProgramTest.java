package org.jerold.dp;

/**
 * Created by jerold on 2017/4/14.
 */
public class DynamicProgramTest {
    private int[] coins = new int[]{1, 3, 5};

    public int getSmallestCoins(int target) {
        if (target == 0)
            return 0;
        int[] tmp = new int[coins.length];
        for (int j = 0; j < coins.length; j++) {
            int left = target - coins[j];
            if (left > 0) {
                tmp[j] = getSmallestCoins(left);
            }
        }
        return min(tmp);
    }

    private int min(int[] tmp) {
        int small = tmp[0];
        for (int i : tmp) {
            if (i < small)
                small = i;
        }
        return small;
    }

    public static void main(String[] args) {
        DynamicProgramTest dp = new DynamicProgramTest();
        int ret = dp.getSmallestCoins(5);
        System.out.println(ret);
    }
}
