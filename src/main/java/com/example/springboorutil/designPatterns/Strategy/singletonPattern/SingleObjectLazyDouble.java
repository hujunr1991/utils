package com.example.springboorutil.designPatterns.Strategy.singletonPattern;

public class SingleObjectLazyDouble {

    private static SingleObjectLazyDouble singleObjectLazyDouble;

    private SingleObjectLazyDouble(){
        if (singleObjectLazyDouble != null) {
            throw new RuntimeException("不能使用反射生成单例");
        }
    }


    private static SingleObjectLazyDouble getInstanse(){
        if (singleObjectLazyDouble == null) {
            synchronized (SingleObjectLazyDouble.class){
                if (singleObjectLazyDouble == null) {
                    singleObjectLazyDouble = new SingleObjectLazyDouble();
                }
            }
        }
        return singleObjectLazyDouble;
    }
}
