package org.jerold.queue;

/**
 * Created by Jerold on 2016/11/4.
 */
public class Queue {
    private int[] elements;
    private int head;
    private int tail;
    private int size;

    public Queue(int n) {
        elements = new int[n];
        head = tail = 0;
    }

    public void add(int i) {
        if (size == elements.length) {
            System.out.println("queue is full");
        } else {
            if (tail == elements.length) {
                tail = 0;
            }
            elements[++tail] = i;
            size++;
        }
    }

    public int poll() {
        if (size == 0) {
            System.out.println("queue is empty");
            if (head - tail == 1)
                head--;
            if (tail - head == elements.length - 1) {
                head = elements.length - 1;
            }
            return 0;
        } else {
            int tmp = elements[head];
            elements[head++] = 0;
            size--;
            return tmp;
        }
    }

    public int peek() {
        if (head == elements.length)
            return 0;
        else return elements[head];
    }
}
