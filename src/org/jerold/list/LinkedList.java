package org.jerold.list;

/**
 * Created by Jerold on 2016/10/29.
 */
public class LinkedList {
    private Node header;
    private Node tail;
    private int size;

    public LinkedList() {

    }

    public boolean addBeforeHeader(int n) {
        Node node = new Node(n);
        return addInternal(node, 0);
    }

    public boolean addAfterTail(int n) {
        Node node = new Node(n);
        return addInternal(node, size);
    }

    public boolean addFromPosition(int n, int position) {
        Node node = new Node(n);
        return addInternal(node, position);
    }

    private boolean addInternal(Node node, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("no such position");
        } else if (header == null) {
            header = node;
            tail = node;
        } else if (position == 0) {
            header.setPre(node);
            node.setNext(header);
            header = node;
        } else if (position == size) {
            tail.setNext(node);
            node.setPre(tail);
            tail = node;
        } else {
            Node pre = header;
            for (int i = 0; i < (position - 1); i++) {
                pre = pre.getNext();
            }
            node.setPre(pre);
            node.setNext(pre.getNext());
            pre.getNext().setPre(node);
            pre.setNext(node);

        }
        size++;
        return true;
    }

    public Node remove(int position) {
        if (position == 0) {
            Node tmp = header;
            header = tmp.getNext();
            tmp = null;
        } else if (position == size) {
            Node tmp = tail;
            tail = tail.getPre();
            tail.setNext(null);
            tmp = null;
        } else {
            Node pre = header;
            for (int i = 1; i < (position - 1); i++) {
                pre = pre.getNext();
            }
            Node current = pre.getNext();
            pre.getNext().getNext().setPre(pre);
            pre.setNext(pre.getNext().getNext());
            current = null;
        }
        size--;
        return header;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        if (header == null) {
            System.out.println("no elements in the list");
        } else {
            Node begin = header;
            while (begin != null) {
                System.out.print(begin.getV() + ", ");
                begin = begin.getNext();
            }
        }
    }

    private class Node {
        private Node pre;
        private Node next;
        int v;

        Node(int v) {
            this.pre = null;
            this.next = null;
            this.v = v;
        }

        private Node getPre() {
            return pre;
        }

        private void setPre(Node pre) {
            this.pre = pre;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private int getV() {
            return v;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.print();
        list.addBeforeHeader(6);
        list.addAfterTail(7);
        list.addFromPosition(8, 1);
        list.addAfterTail(5);
        list.print();
        System.out.println();
        System.out.println(list.getSize());
        list.remove(2);
        list.print();
        System.out.println();
        System.out.println(list.getSize());
    }
}
