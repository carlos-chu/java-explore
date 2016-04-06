package org.learning.datastructure;

public interface KIList<T> {

    void add(T item);

    void add(int index, T item);

    void set(int index, T item);

    void remove(T item);

    void remove(int index);

    boolean contains(T item);

    boolean isEmpty();

    T get(int index);

    int indexOf(T item);

    int size();
}
