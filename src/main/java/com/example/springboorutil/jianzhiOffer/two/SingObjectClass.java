package com.example.springboorutil.jianzhiOffer.two;

public class SingObjectClass {

    private volatile static SingObjectClass instance;

    private SingObjectClass() {
        if (instance != null) {
            throw new RuntimeException("禁止使用反射");
        }
    }

    private SingObjectClass getInstance() {
        if (instance == null) {
            synchronized (SingObjectClass.class) {
                if (instance == null) {
                    instance = new SingObjectClass();
                }
            }
        }

        return instance;
    }



}
