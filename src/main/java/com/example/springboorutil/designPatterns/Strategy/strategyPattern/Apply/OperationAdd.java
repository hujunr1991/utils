package com.example.springboorutil.designPatterns.Strategy.strategyPattern.Apply;

import java.util.List;

public class OperationAdd implements SuperInterface {

    private static OperationAdd add = null;

    private OperationAdd(){}

    public static OperationAdd getInstance(){
        if(add == null){
            synchronized (OperationAdd.class) {
                add = new OperationAdd();
            }
        }
        return add;
    }

    @Override
    public Object doOperation(List objs) {
        double sum = 0;
        for(Object obj:objs){
            double temp = Double.valueOf(obj.toString());
            sum += temp;
        }
        return sum;
    }
}
