package com.example.springboorutil.DataStructures.Set;

public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
