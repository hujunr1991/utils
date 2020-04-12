package com.example.springboorutil.designPatterns.Strategy.xiangyuanPattern;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public static List<Book> books = new ArrayList<>();

    public static Llibrary llibrary;

    public static void main(String[] args) {
        llibrary = Llibrary.getInstance();

        studentBorrow("java编程思想");
        studentBorrow("java1");
        studentBorrow("java2");
        System.out.println("又借了一次");
        studentBorrow("java1");
        studentBorrow("java2");

        for (Book book : books){
            book.borrow();
        }

        System.out.println("学生一共借了" + books.size() + "本书！");

        System.out.println("图书馆实际借出" + llibrary.getAllBookSize() + "本书");


    }

    private static void studentBorrow(String bookName) {
        books.add(llibrary.libToBorrow(bookName));
    }
}
