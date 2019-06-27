package com.example.springboorutil.DataStructures.Array;

public class Array02<E> {
    private E[] date;
    private  int size;
    public Array02(int capacity){
        date = (E[])new Object[capacity];
        size = 0;
    }
    private Array02(){
       this(10);
    }

    public int getCapacity(){
        return date.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素
    public void add(int index, E a){
        if (date.length == size) {
           resize(2 * date.length);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= index ;i--) {
            date[i+1] = date[i];
        }
        date[index] = a;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0;i < size; i++) {
            newData[i] = date[i];
        }
        date = newData;
    }

    public void addLast(int size, E a){
        add(size, a);
    }

    public void addFrist( E a){
        add(0, a);
    }

    //获取索引元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ill index, Require index >= 0 and index <= size.");
        }
        return date[index];
    }

    //修改元素
    public E update(E a, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ill index, Require index >= 0 and index <= size.");
        }
        date[index] = a;
        return a;
    }

    //判断是否包含元素
    public boolean contains(E a ) {
        for(int i = 0; i< size; i++) {
            if (date[i] == a) {
                return true;
            }
        }
        return false;
    }

    //查找元素
    public int find(E a) {
        for(int i = 0; i< size; i++) {
            if (date[i] == a) {
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
            date[i-1] = date[i];
        }
        size--;
        //防止复杂度震荡，且date.length不能等于0
        if (size == date.length/4 && date.length /2 != 0) {
            resize(date.length/2);
        }
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
    public void removeElement(E a) {
        int index = find(a);
        if (index != -1) {
            remove(index);
        }
    }

}
