package com.example.springboorutil.jianzhiOffer.two;

import java.util.Stack;

public class Problem07<T> {


    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void addTail(T t) {
        stack1.push(t);
    }

    //原则：当stack2为空时，把stack1里面的元素全部压入stack2
    public T deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                T pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("队列为空，不能删除");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Problem07<String> p7=new Problem07<>();
        p7.addTail("1");
        p7.addTail("2");
        p7.addTail("3");
        String s = p7.deleteHead();
        System.out.println(s);

    }
}
