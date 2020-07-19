package com.example.springboorutil.designPatterns.Strategy.adapterPattern.adapterClass;

public class ConcetAdapter implements Target {

    @Override
    public void adapter() {
        System.out.println("实现该方法");
    }
}
