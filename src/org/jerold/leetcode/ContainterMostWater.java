package org.jerold.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Created by Jerold on 2019/1/5.
 */
public class ContainterMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea2(height);
        System.out.println(maxArea);
    }

    private static int maxArea(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmpArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, tmpArea);
            }
        }
        return maxArea;
    }

    private static int maxArea2(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] <= height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[i]);
                i++;
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[j]);
                j--;
            }
        }
        return maxArea;
    }
}
