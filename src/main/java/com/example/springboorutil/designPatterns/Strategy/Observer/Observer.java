package com.example.springboorutil.designPatterns.Strategy.Observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
