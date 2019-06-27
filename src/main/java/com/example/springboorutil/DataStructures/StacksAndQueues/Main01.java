package com.example.springboorutil.DataStructures.StacksAndQueues;

public class Main01 {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();
        ArrayStackTest<Integer> stackTest = new ArrayStackTest<>();

        for (int i = 0; i < 5; i++) {
            stackTest.push(i);
            System.out.println(stackTest);
        }
        stackTest.pop();
        System.out.println(stackTest);

        System.out.println("=======");
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
