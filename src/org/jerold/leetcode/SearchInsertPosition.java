package org.jerold.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 * <p>
 * Created by Jerold on 2019/1/13.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        // 0, 3
        // mid = 1 = (0+3)/2;
        // left[0,1];
        // right[2,3];
        // 0, 4
        // mid = 2 = (0+4)/2;
        // left[0,2];
        // right[3,4];
        /*int[] nums = new int[]{1, 3, 5, 6};
        int position = searchInsert(nums, 5);
        System.out.println(position);
        position = searchInsert(nums, 2);
        System.out.println(position);
        position = searchInsert(nums, 7);
        System.out.println(position);
        position = searchInsert(nums, 0);
        System.out.println(position);*/
        int[] nums = new int[]{1};
        int position = searchInsert(nums, 0);
        System.out.println(position);
    }

    private static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchPosition(nums, 0, nums.length - 1, target);
    }

    private static int searchPosition(int[] nums, int l, int r, int target) {
        if (l < r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                return searchPosition(nums, l, mid - 1, target);
            } else {
                return searchPosition(nums, mid + 1, r, target);
            }
        } else {
            if (target <= nums[l]) {
                return l;
            } else {
                return l + 1;
            }
        }
    }
}
