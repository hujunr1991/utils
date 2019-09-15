package com.example.springboorutil.designPatterns.Strategy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("加法：" + context.executeStrategy(5, 10));

        context = new Context(new OperationMultiply());
        System.out.println("乘法：" + context.executeStrategy(5 , 10));

        context = new Context(new OperationSubstract());
        System.out.println("除法" + context.executeStrategy(5, 10));

        context.setStrategy(new OperationSubstract());

        System.out.println(context.executeStrategy(15,3));
    }
}
