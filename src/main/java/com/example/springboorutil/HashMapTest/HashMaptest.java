package com.example.springboorutil.HashMapTest;


import com.github.pagehelper.PageHelper;

import java.util.*;

public class HashMaptest {

    public static void main(String[] args) {

//        Map<Integer, String> map1 = new HashMap<>(16);
//        Map<Integer, String> map = new HashMap<>();
//        for (int i = 0; i < 33; i++) {
//            map.put(i, UUID.randomUUID().toString());
//        }


        /*
        https://www.cnblogs.com/vipstone/p/12803575.html
        使用迭代器（Iterator）EntrySet 的方式进行遍历；
        使用迭代器（Iterator）KeySet 的方式进行遍历；
        使用 For Each EntrySet 的方式进行遍历；
        使用 For Each KeySet 的方式进行遍历；
        使用 Lambda 表达式的方式进行遍历；
        使用 Streams API 单线程的方式进行遍历；
        使用 Streams API 多线程的方式进行遍历。
         */

        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println("key是：" + next.getKey() + "，value是:" + next.getValue());
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer key = iterator1.next();
            System.out.println("key是：" + key + "，value是:" + map.get(key));
        }

        for (Map.Entry<Integer, String> iter : map.entrySet()) {
            System.out.println("key是：" + iter.getKey() + "，value是:" + iter.getValue());
        }

        Set<Integer> integers = map.keySet();
        for (Integer integer : map.keySet()) {
            System.out.println("key是：" + integer + "，value是:" + map.get(integer));
        }

        map.forEach((key, value) -> {
            System.out.println("key是：" + key + "，value是:" + value);
        });


        //Streams API 单线程
        map.entrySet().stream().forEach((entry) -> {
            System.out.println("key是：" + entry.getKey() + "，value是:" + entry.getValue());
        });

        map.entrySet().parallelStream().forEach((entry -> {
            System.out.println("key是：" + entry.getKey() + "，value是:" + entry.getValue());
        }));

        PageHelper.startPage(1, 5);



    }






}
