package com.example.springboorutil.DataStructures.LinkedlLIst;

public interface Queue<E> {

    public int getSize();

    boolean isEmpty();

    void enqueue(E e);
    E dequeue();
    E getFront();
}
