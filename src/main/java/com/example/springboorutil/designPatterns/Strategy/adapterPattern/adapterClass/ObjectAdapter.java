package com.example.springboorutil.designPatterns.Strategy.adapterPattern.adapterClass;

public class ObjectAdapter implements Target {


    Adaptee adaptee = new Adaptee();

    @Override
    public void adapter() {
        adaptee.adapter01();
    }
}
