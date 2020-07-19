package com.example.springboorutil.designPatterns.Strategy.adapterPattern.adapterClass;

public class Adapter extends Adaptee implements Target{
    @Override
    public void adapter() {
       super.adapter01();
    }
}
