package org.jerold.algorithm;

import org.jerold.stack.Stack;

import java.util.Queue;

/**
 * Created by Jerold on 2016/11/3.
 */
public class QueueAlgorithm {
    // 1. 给定一个整数队列，如何把队列的前半部分和后半部分相互交叉，完成队列中元素的重新排列
    public void alternateQueue(Queue queue) {
        if (queue.size() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        Stack stack = new Stack();
        int halfSize = queue.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            stack.push((int) queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < halfSize; i++) {
            queue.add(queue.poll());
        }
        for (int i = 0; i < halfSize; i++) {
            stack.push((int) queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.poll());
        }
    }
}
