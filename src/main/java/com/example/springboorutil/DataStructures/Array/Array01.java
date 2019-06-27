package com.example.springboorutil.DataStructures.Array;

public class Array01 {
    private int[] e;
    private  int size;
    public Array01(int capacity){
        e = new int[capacity];
        size = 0;
    }
    private Array01(){
       this(10);
    }

    public int getCapacity(){
        return e.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素
    public void add(int index, int a){
        if (e.length == size) {
            throw new IllegalArgumentException("add id fail, arrray is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= index ;i--) {
            e[i+1] = e[i];
        }
        e[index] = a;
        size++;
    }

    public void addLast(int size, int a){
        add(size, a);
    }

    public void addFrist( int a){
        add(0, a);
    }

    //获取索引元素
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ill index, Require index >= 0 and index <= size.");
        }
        return e[index];
    }

    //修改元素
    public int update(int a, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ill index, Require index >= 0 and index <= size.");
        }
        e[index] = a;
        return a;
    }

    //判断是否包含元素
    public boolean contains(int a ) {
        for(int i = 0; i< size; i++) {
            if (e[i] == a) {
                return true;
            }
        }
        return false;
    }

    //查找元素
    public int find(int a) {
        for(int i = 0; i< size; i++) {
            if (e[i] == a) {
                return i;
            }
        }
        return -1;
    }

    //依据索引删除元素
    public void remove(int index ){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ill index, Require index >= 0 and index <= size.");
        }
        for(int i = index +1; i <size; i++) {
            e[i-1] = e[i];
        }
        size--;
    }

    //删除第一个元素
    public void removeFrist() {
        remove(0);
    }

    //删除最后一个元素
    public void removeLast() {
        remove(size-1);
    }

    //删除某个元素
    public void removeElement(int a) {
        int index = find(a);
        if (index != -1) {
            remove(index);
        }
    }

}
