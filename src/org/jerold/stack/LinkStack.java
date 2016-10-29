package org.jerold.stack;

import org.jerold.list.SingleLinkList;

/**
 * Created by Jerold on 2016/10/29.
 */
public class LinkStack {
    private SingleLinkList sll;

    public void push(int i) {
        sll.add(i);
    }

    public int pop() {
        return (int) sll.removeFromTail();
    }

    private int getSize() {
        return sll.size();
    }

    public void print() {

    }
}
