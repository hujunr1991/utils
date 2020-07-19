package com.example.springboorutil.mythread;

import static java.lang.Thread.sleep;

public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized(resource1) {
                System.out.println(System.currentTimeMillis() + "get resources1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(System.currentTimeMillis() + "wait resources1");

                synchronized (resource2) {
                    System.out.println(System.currentTimeMillis() + "get resources2");
                }

            }
        }, "线程1").start();

        new Thread(() ->{
           synchronized (resource1) {
               System.out.println(System.currentTimeMillis() + "get resources2");

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               System.out.println(System.currentTimeMillis() + "wait resources2");

               synchronized (resource2) {
                   System.out.println(System.currentTimeMillis() + "get resources1");
               }
           }
        }, "线程2").start();
    }
}
