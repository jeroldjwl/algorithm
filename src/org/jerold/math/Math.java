package org.jerold.math;

/**
 * Created by Jerold on 2016/10/28.
 */
public class Math {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the input must bigger than 0");
        } else if (n == 0 || n == 1)
            return 1;
        else {
            return n * factorial((--n));
        }
    }

    public static void main(String[] args) {
        int i = factorial(11);
        System.out.println(i);
    }
}
