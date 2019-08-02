package com.example.springboorutil.DataStructures.Heap;

import com.example.springboorutil.DataStructures.Array.Array02;

public class MaxHeap<E extends Comparable<E>> {
    private Array02<E> data;

    public MaxHeap(int capacity) {
        data = new Array02<>(capacity);
    }

    public MaxHeap() {
        data = new Array02<>();
    }

    public MaxHeap(E[] arr){
        data = new Array02<>(arr);
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            siftDown(i);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }


    public int size(){
        return data.getSize();
    }

    public int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }


    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(size(), e);
        sifUp(data.getSize() - 1);
    }

    private void sifUp(int i) {
        while (i>0 && data.get(parent(i)).compareTo(data.get(i))< 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax(){

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){

        while(leftChild(k) < data.getSize()){
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 )
                j ++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;

            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
