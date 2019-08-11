package com.example.springboorutil.javaMultiThread.t10;

/**
 * className PrintString
 * description
 *
 * @author feng
 * @version 1.0
 * @date 2019/1/15 下午8:29
 */
public class PrintString implements Runnable {
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("run printStringMethod thread name = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        printStringMethod();
    }
}
