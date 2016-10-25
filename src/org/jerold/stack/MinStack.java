package org.jerold.stack;

/**
 * Created by Jerold on 2016/10/24.
 */
public class MinStack {
    private int[] elements;
    private int min;
    private Stack ms;
    private int size = -1;

    public MinStack() {
        elements = new int[10];
        ms = new Stack();
    }

    public int pop() {
        int e = 0;
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size >= 0) {
            e = elements[size];
            elements[size--] = 0;
        }
        if (e == min) {
            ms.pop();
            int i = ms.peek();
            min = elements[i];
        }
        return e;
    }

    public int push(int item) {
        elements[++size] = item;
        if (item < min || (size == 0)) {
            min = item;
            ms.push(size);
        }
        return item;
    }

    public int getMin() {
        if (size < 0) {
            System.out.println("no more element in stack");
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(6);
        ms.push(2);
        System.out.println(ms.getMin());//2
        ms.pop();//2 out
        System.out.println(ms.getMin());//3
        ms.pop();//6 out
        System.out.println(ms.getMin());//3
        ms.pop();//3 out
        System.out.println(ms.getMin());//5
        ms.pop();//5 out
        System.out.println(ms.getMin());//0
    }

}
