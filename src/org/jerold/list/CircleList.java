package org.jerold.list;

/**
 * Created by Jerold on 2016/10/29.
 */
public class CircleList {
    private Node header;
    private Node tail;
    private int size;

    public CircleList() {

    }

    public void add(int i) {
        Node n = new Node(i);
        addInternal(n);
    }

    private void addInternal(Node node) {
        if (header == null) {
            header = node;
            tail = node;
            tail.next = header;
            size++;
        } else {
            tail.next = node;
            tail = node;
            tail.next = header;
            size++;
        }
    }

    private int getSize() {
        return size;
    }

    public void print() {
        Node tmp = header;
        while (tmp != null) {
            System.out.print(tmp.v + ", ");
            tmp = tmp.next;
            if (tmp == header)
                break;
        }
    }

    private class Node {
        int v;
        Node next;

        Node(int v) {
            this.v = v;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CircleList cl = new CircleList();
        cl.add(4);
        cl.add(5);
        cl.add(7);
        cl.add(2);
        cl.add(1);
        cl.add(8);
        cl.print();
        System.out.println();
        System.out.println(cl.getSize());
    }
}
