package com.example.springboorutil.designPatterns.Strategy.singletonPattern;

import org.junit.Test;

public class SingletonPatternDemo {

    @Test
    public void test(){
//        SingleObject singleObject = new SingleObject();
        SingleObject newInstance = SingleObject.getInstance();

        newInstance.showMessage();

        SingleObjectLazy singleObjectLazy = SingleObjectLazy.getInstance();
    }
}
