package com.example.springboorutil.designPatterns.Strategy.strategyPattern.Apply;

import java.util.List;

public class OperationSub implements SuperInterface {


    private OperationSub(){}

    private static OperationSub sub = null;

    public static OperationSub getInstance(){
        if(sub == null){
            synchronized (OperationSub.class) {
                sub = new OperationSub();
            }
        }
        return sub;
    }
    @Override
    public Object doOperation(List objs) {
        double First = Double.valueOf(objs.get(0).toString());
        int i=0;
        for(Object d:objs){
            if(i == 0){
                i =1;
                continue;
            }
            double temp = Double.valueOf(d.toString());
            First -= temp;
        }
        return First;
    }

}
