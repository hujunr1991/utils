package com.example.springboorutil.DataStructures.Set;

import com.example.springboorutil.DataStructures.BST.BSTtest;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BSTtest bsTtest;

    public BSTSet(BSTtest bsTtest) {
        bsTtest = new BSTtest();
    }

    @Override
    public void add(E e) {
        bsTtest.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bsTtest.contains(e);
    }

    @Override
    public void remove(E e) {
        bsTtest.remove(e);
    }

    @Override
    public int getSize() {
        return bsTtest.getSzie();
    }

    @Override
    public boolean isEmpty() {
        return bsTtest.isEmpty();
    }
}
