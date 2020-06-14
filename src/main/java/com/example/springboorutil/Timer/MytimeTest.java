package com.example.springboorutil.Timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MytimeTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask("test");
//        timer.schedule(myTimerTask, 1000,1000);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        calendar.add(Calendar.SECOND, 3);
//        myTimerTask.setName("schedule1");
//        timer.schedule(myTimerTask, calendar.getTime(),1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("exec time is :" +
                        simpleDateFormat.format(scheduledExecutionTime()));
            }
        }, calendar.getTime() ,1000);

        System.out.println("======");
    }
}
