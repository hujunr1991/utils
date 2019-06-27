package com.example.springboorutil.DataStructures.Queue;

public class LoopQueueTest<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;


    public LoopQueueTest(int capacity){
        //用一个空间换取实现的逻辑，使得 (tail + 1) % data.length == front 为满
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueTest(){
        data = (E[]) new Object[10];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //对列满了
        if ((tail + 1) % data.length == front) {
            resize(data.length * 2);
        }
        data[tail] = e;
        //tail如何处理
        tail = (tail + 1) %data.length;
        size++;

    }

    private void resize(int captacity) {
        E[] newData = (E[]) new Object[captacity];
        for (int i=0; i< data.length; i++) {
            //front不是从0开始
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() /4 && getCapacity() /2 != 0)
            resize(data.length/2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
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
