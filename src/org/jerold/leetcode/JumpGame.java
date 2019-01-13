package org.jerold.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * <p>
 * You can assume that you can always reach the last index.
 * Created by Jerold on 2019/1/6.
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    private static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] == nums.length - 1) {
            return 1;
        }
        int steps = nums.length - 1;
        return 0;
    }
}
