package com.example.springboorutil.DataStructures.Queue;

import com.example.springboorutil.DataStructures.StacksAndQueues.ArrayTest;

public class ArrayQueueTest<E> implements Queue<E>{

    private ArrayTest<E> array;

    public ArrayQueueTest(int capacity) {
        array = new ArrayTest<>(capacity);
    }

    public ArrayQueueTest(){
        array = new ArrayTest<>();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getSize(){
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public void enqueue(E e){
        array.addLast(e);
    }

    public E dequeue(){
        return array.removeFrist();
    }

    public E getFront(){
        return array.getFrist();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
