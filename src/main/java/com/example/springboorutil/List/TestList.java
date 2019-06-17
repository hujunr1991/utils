/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.springboorutil.List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description
 * 使用filter过滤出符合特定条件的元素List
 *
 * @author hujun [hu.jun@unisinsight.com]
 * @date 2019/05/08 11:44
 * @since 1.0
 */
public class TestList {
    /**
     * 准备书的列表数据
     *
     * @return
     */
    public static List<Book> prepareData() {
        // 准备书的列表，id是从1到10
        List<Book> bookList = new ArrayList<Book>();
        for (int i = 1; i < 11; i++) {
            bookList.add(new Book(String.valueOf(i), "book" + i));
        }
        return bookList;
    }

    public static void main(String[] args) {
        List<Book> bookList = prepareData();
        System.out.println(bookList);

        // 要被找出的书的ID
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("3");
        ids.add("6");
        ids.add("8");
        ids.add("9");

        // 存放过滤结果的列表
        List<Book> result = null;

        // 使用lambda表达式过滤出结果并放到result列表里，written by zhangchao
        result = bookList.stream()
                .filter((Book b) -> ids.contains(b.getId()))
                .collect(Collectors.toList());

        // 打印结果列表
        if (result != null && !result.isEmpty()) {
            result.forEach((Book b) -> System.out.println(b.getId() + "  " + b.getName()));
        }
    }
}
