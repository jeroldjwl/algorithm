package org.jerold.stack;

/**
 * Created by Jerold on 2016/10/23.
 */
public class Stack {
    private int[] elements;
    private int top;

    public Stack() {
        elements = new int[10];
    }

    public int push(int i) {
        elements[++top] = i;
        return i;
    }

    public int peek() {
        return elements[top];
    }

    public int pop() {
        int e = 0;
        if (top >= 0) {
            e = elements[top];
            elements[top--] = 0;
            return e;
        } else {
            throw new IllegalArgumentException("no more data in stack");
        }
    }

    public boolean isEmpty() {
        return top < 0;
    }
}
