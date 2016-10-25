package org.jerold.list;

import java.util.Iterator;

/**
 * Created by Jerold on 2016/10/23.
 */
public class SingleLinkList<E> implements List<E> {
    private Node header;
    private Node tail;
    private int size;

    @Override
    public boolean add(E e) {
        Node n = new Node(e);
        if (header == null) {
            header = n;
            tail = n;
            size++;
        } else {
            tail.setNext(n);
            tail = n;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean success = false;
        Node n = header;
        if (o.equals(n.getValue())) {
            success = true;
        }
        while (n != null) {
            Node tmp = n.getNext();
            if (tmp != null && o.equals(tmp.getValue())) {
                n.setNext(n.getNext().getNext());
                size--;
                success = true;
                break;
            }
            n = n.getNext();
        }
        return success;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        Node n = header;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        return n.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean found = false;
        Node n = header;
        while (n != null) {
            if (o.equals(n.getValue())) {
                found = true;
                break;
            }
            n = n.getNext();
        }
        return found;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            return null;
        }
    }

    public void print() {
        if (header != null) {
            Node n = header;
            while (n != null) {
                System.out.print(n.getValue() + ", ");
                n = n.getNext();
            }
        }
    }

    public void printFromTail() {
        Node node = header;
        printRecursive(node);
    }

    private void printRecursive(Node header) {
        if (header != null) {
            if (header.getNext() != null) {
                printRecursive(header.getNext());
            }
            System.out.print(header.getValue() + ", ");
        }
    }

    class Node {
        private E e;
        private Node next;

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public E getValue() {
            return e;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            this.next = n;
        }
    }
}
