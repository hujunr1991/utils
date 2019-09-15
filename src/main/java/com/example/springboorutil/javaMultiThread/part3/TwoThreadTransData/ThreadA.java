package com.example.springboorutil.javaMultiThread.part3.TwoThreadTransData;

public class ThreadA extends Thread {
    private MyList list;
    public ThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i< 10; i++) {
                list.add();
                System.out.println("添加了" + (i+1) + "个元素");
                Thread.sleep(10000);
            }
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
