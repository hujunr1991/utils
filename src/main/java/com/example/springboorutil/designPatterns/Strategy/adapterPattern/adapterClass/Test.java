package com.example.springboorutil.designPatterns.Strategy.adapterPattern.adapterClass;

public class Test {

    public static void main(String[] args) {

        Target target = new Adapter();
        ((Adapter) target).adapter01();
    }
}
