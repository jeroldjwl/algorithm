package org.jerold.leetcode;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * Created by Jerold on 2019/1/6.
 */
public class ParitySortArray {

    public static void main(String[] args) {
        int[] A = new int[]{3};
        A = sortArrayByParity(A);
        for (int a : A) {
            System.out.print(a + ", ");
        }
    }

    private static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int l = 0, r = A.length - 1;
        while (l < r) {
            while (l < r && A[l] % 2 == 0)
                l++;
            int tmp = A[l];
            while (l < r && A[r] % 2 != 0)
                r--;
            A[l] = A[r];
            A[r] = tmp;
            l++;
            r--;
        }
        return A;
    }
}
