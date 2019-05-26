package com.example.springboorutil.DataStructures.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }
}
