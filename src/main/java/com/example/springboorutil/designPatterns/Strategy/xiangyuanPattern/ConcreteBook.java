package com.example.springboorutil.designPatterns.Strategy.xiangyuanPattern;

public class ConcreteBook implements Book {
    private String name;

    public ConcreteBook(String name) {
        this.name = name;
    }

    @Override
    public void borrow() {
        System.out.println("图书馆借出去的书是:" + this.name);
    }
}
