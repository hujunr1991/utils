package com.example.springboorutil.designPatterns.Strategy.singletonPattern;

public class SingleObjectHunger {

    private static SingleObjectHunger singleObjectHunger = new SingleObjectHunger();

    private SingleObjectHunger(){}

    public static SingleObjectHunger getInstanse(){
        return singleObjectHunger;
    }

}
