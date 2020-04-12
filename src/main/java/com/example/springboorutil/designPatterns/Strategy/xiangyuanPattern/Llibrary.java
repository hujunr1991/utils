package com.example.springboorutil.designPatterns.Strategy.xiangyuanPattern;


import java.util.HashMap;
import java.util.Map;

public class Llibrary {
    //维护一个图书馆列表
    private Map<String, Book> bookPools = new HashMap<>();

    private static Llibrary factory = new Llibrary();

    public static Llibrary getInstance() {
        return factory;
    }

    public Book libToBorrow(String bookName) {
        Book order = null;
        //https://baijiahao.baidu.com/s?id=1639843210271222415&wfr=spider&for=pc
        if (bookPools.containsKey(bookName)) {
            order = bookPools.get(bookName);
        }else {
            order = new ConcreteBook(bookName);
            bookPools.put(bookName, order);
        }
        return order;
    }

    public int getAllBookSize(){
        return bookPools.size();
    }

}
