package org.jerold.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * [1,1,1,0]
 * -100
 * <p>
 * [1,1,-1,-1,3]
 * 3
 * <p>
 * [-4, -1, 1, 2]
 * 3
 * <p>
 * Created by Jerold on 2019/1/5.
 */
public class SumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1};
        int closetSum = threeSumClosest(nums, 1);
        System.out.println(closetSum);
        nums = new int[]{1, 1, -1, -1, 3};
        closetSum = threeSumClosest2(nums, 3);
        System.out.println(closetSum);
    }

    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int closestSum = Integer.MAX_VALUE;
        int absDis = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int subSum = nums[i] + nums[j] + nums[k];
                    int tmpDis = Math.abs(target - subSum);
                    if (tmpDis < absDis) {
                        absDis = tmpDis;
                        closestSum = subSum;
                    }
                }
            }
        }
        return closestSum;
    }

    private static int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int closestSum = 0;
        int absDis = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int tmpSum = nums[i] + nums[start] + nums[end];
                if (tmpSum == target) {
                    return tmpSum;
                }
                int tmpDis = Math.abs(target - tmpSum);
                if (tmpDis < absDis) {
                    absDis = tmpDis;
                    closestSum = tmpSum;
                }
                if (tmpSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return closestSum;
    }
}
