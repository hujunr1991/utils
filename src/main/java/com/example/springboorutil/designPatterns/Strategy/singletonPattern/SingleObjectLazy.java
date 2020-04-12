package com.example.springboorutil.designPatterns.Strategy.singletonPattern;

public class SingleObjectLazy {

    public static SingleObjectLazy singleObjectLazy;

    private SingleObjectLazy(){}

    public static SingleObjectLazy getInstance(){
        if (singleObjectLazy ==null) {
            singleObjectLazy = new SingleObjectLazy();
        }

        return singleObjectLazy;
    }

    public static synchronized SingleObjectLazy getInstanceSafe(){
        if (singleObjectLazy ==null) {
            singleObjectLazy = new SingleObjectLazy();
        }

        return singleObjectLazy;
    }
}
