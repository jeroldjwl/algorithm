package org.jerold.list;

import java.util.Iterator;

/**
 * Created by Jerold on 2016/10/23.
 */
public interface List<E> {
    boolean add(E e);

    boolean remove(Object o);

    int size();

    E get(int index);

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();
}
