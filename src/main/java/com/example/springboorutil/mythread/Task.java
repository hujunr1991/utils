package com.example.springboorutil.mythread;

public class Task {
    public  void doLongTimeTask() {
        for (int i = 0; i< 100; i++) {
            System.out.println("nosynchronized threadNmae = " + Thread.currentThread().getName()
             + "i = " + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i =0; i < 100;i++) {
                System.out.println("synchronized threadName" + Thread.currentThread().getName()
                 + "i=" + (i+1));
            }
        }
    }
}


