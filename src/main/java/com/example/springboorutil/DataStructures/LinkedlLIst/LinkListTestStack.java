package com.example.springboorutil.DataStructures.LinkedlLIst;

public class LinkListTestStack<E> implements Stack<E> {

    private LinkListTest<E> list;

    public LinkListTestStack(){
        list = new LinkListTest<>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.add(0, e);
    }

    @Override
    public E pop() {

        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkListTestStack<Integer> stack = new LinkListTestStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
