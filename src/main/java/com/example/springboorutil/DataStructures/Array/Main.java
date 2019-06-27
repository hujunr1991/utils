package com.example.springboorutil.DataStructures.Array;

public class Main {

    public static void main(String[] args) {

//        Array<Integer> arr = new Array<>();
//        for (int i = 0; i < 10; i++)
//            arr.addLast(i);
//        System.out.println(arr);
//
//        arr.add(1, 100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
//
//        for (int i = 0; i < 4; i++) {
//            arr.removeFirst();
//            System.out.println(arr);
//        }

        Array01 arr = new Array01(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addFrist(i);
        boolean contains = arr.contains(5);
        System.out.println(contains);

        System.out.println(arr.find(5));

        arr.remove(5);

        System.out.println(arr.find(5));

        arr.removeElement(5);
    }
}
