package org.jerold.leetcode;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * [-2, -1, 0, 0, 1, 2]
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * [1,0,-1,0,-2,2]
 * 0
 * [0,0,0,0]
 * 0
 * <p>
 * [-1,0,-5,-2,-2,-4,0,1,-2]
 * -9
 * Created by Jerold on 2019/1/5.
 */
public class FourSum {
    public static void main(String[] args) {
        // -5, -4, -2, -2, -2, -1, 0, 0, 1
        int[] nums = new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2};
        List<List<Integer>> result = fourSum(nums, -9);
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        Set<String> numsStrSet = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        String numStr = String.valueOf(nums[i]) +
                                nums[j] +
                                nums[l] +
                                nums[r];
                        if (!numsStrSet.contains(numStr)) {
                            List<Integer> sub = new ArrayList<>(4);
                            sub.add(nums[i]);
                            sub.add(nums[j]);
                            sub.add(nums[l]);
                            sub.add(nums[r]);
                            result.add(sub);
                            numsStrSet.add(numStr);
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
