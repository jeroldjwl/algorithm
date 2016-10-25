package org.jerold.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Jerold on 2016/10/23.
 */
public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public ArrayList() {
        this.elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(int num) {
        if (num > 0)
            this.elements = new Object[num];
        else if (num == 0)
            this.elements = EMPTY_ELEMENTDATA;
        else {
            throw new IllegalArgumentException("Illegal Capacity: " + num);
        }
    }

    private void ensureCapacity(int capacity) {
        if (elements == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            capacity = Math.max(DEFAULT_CAPACITY, capacity);
        }
        ensureCapacityInternal(capacity);
    }

    private void ensureCapacityInternal(int capacity) {
        if (capacity - elements.length > 0) {
            grow(capacity);
        }
    }

    private void grow(int capacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - capacity < 0) {
            newCapacity = capacity;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;
        return (E) elements[index];
    }

}
