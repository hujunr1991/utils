package com.example.springboorutil.DataStructures.BST;

public class BST<E extends Comparable<E>> {

    public class Node{
        private E e;
        public Node left, right;
        private Node(){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }



}
