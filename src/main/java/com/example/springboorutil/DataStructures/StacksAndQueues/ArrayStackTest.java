package com.example.springboorutil.DataStructures.StacksAndQueues;

public class ArrayStackTest<E> implements Stack<E> {
    private ArrayTest<E> array;

    public ArrayStackTest(int capacity) {
        array = new ArrayTest<>(capacity);
    }

    public ArrayStackTest() {
       array = new ArrayTest<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack");
        sb.append("[");
        for (int i = 0; i<array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
