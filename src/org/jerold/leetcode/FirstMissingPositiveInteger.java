package org.jerold.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 * Created by Jerold on 2019/1/13.
 */
public class FirstMissingPositiveInteger {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        int ret = firstMissingPositive(nums);
        System.out.println(ret);
        nums = new int[]{3, 4, -1, 1};
        ret = firstMissingPositive(nums);
        System.out.println(ret);
        nums = new int[]{7, 8, 9, 11, 12};
        ret = firstMissingPositive(nums);
        System.out.println(ret);
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
            max = Math.max(max, num);
        }
        int i = 1;
        while (i <= max) {
            if (set.contains(i)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }
}
