package com.example.springboorutil.designPatterns.Strategy.factoryPattern;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("输出为长方形");
    }
}
