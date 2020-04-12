package com.example.springboorutil.designPatterns.Strategy.factoryPattern;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("输出为正方形");
    }
}
