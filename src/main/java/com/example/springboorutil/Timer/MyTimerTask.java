package com.example.springboorutil.Timer;

import lombok.Data;

import java.util.TimerTask;

@Data
public class MyTimerTask extends TimerTask {
    private String name;
    private Integer count = 0;

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (count < 3) {
            count++;
            System.out.println("name is :" + name);
        } else {
            cancel();
        }

    }
}
