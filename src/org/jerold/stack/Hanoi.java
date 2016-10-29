package org.jerold.stack;

/**
 * Created by Jerold on 2016/10/28.
 */
public class Hanoi {
    public static void hanoi(int n, char frompeg, char topeg, char auxpeg) {
        if (n == 1) {
            System.out.println("move disk from peg " + frompeg + " to peg " + topeg);
            return;
        }
        hanoi(n - 1, frompeg, auxpeg, topeg);
        System.out.println("move disk from peg " + frompeg + " to peg " + topeg);
        hanoi(n - 1, auxpeg, topeg, frompeg);
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
}
