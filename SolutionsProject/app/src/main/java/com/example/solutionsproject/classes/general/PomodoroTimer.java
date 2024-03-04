package com.example.solutionsproject.classes.general;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private Timer timer;
    private boolean isWorkTime;
    public static int work;
    public static int break_;
    public static int long_;
    public static int break_interval;
    private TextView display, interval;
    private int interval_ctr;

    public PomodoroTimer(int work, int break_, int long_, int break_interval, TextView display, TextView interval) {
        this.work = work;
        this.break_ = break_;
        this.long_ = long_;
        this.break_interval = break_interval;
        this.interval = interval;
        this.display = display;

        timer = new Timer();
        isWorkTime = true;
    }

    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (isWorkTime) {
                    display.setText("Break time");
                    System.out.println("Work time is over! Take a break.");
                    isWorkTime = false;
                    if(interval_ctr >= break_interval){
                        interval_ctr = 0;
                        scheduleLongBreak();
                    }else{
                        scheduleBreak();
                    }
                } else {
                    System.out.println("Break time is over! Back to work.");
                    isWorkTime = true;
                    scheduleWork();
                    interval_ctr++;
                    interval.setText("" + (break_interval - interval_ctr));
                }
            }
        };

        interval.setText("" + (break_interval - interval_ctr));
        display.setText("Work time");
        System.out.println("Start working for "+ work + " minute(s).");
        scheduleWork(); // Start with work time
        timer.schedule(task, work * 60 * 1000); // Schedule the initial task
    }

    private void scheduleWork() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                start(); // Start the timer again after work time
            }
        }, work * 60 * 1000);
    }

    private void scheduleBreak() {
        System.out.println("Take a " + break_ + " minute break.");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                start(); // Start the timer again after break time
            }
        }, break_ * 60 * 1000);
    }

    private void scheduleLongBreak() {
        display.setText("Long break time");
        System.out.println("Take a long " + long_+ " minute break.");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                start(); // Start the timer again after break time
            }
        }, long_ * 60 * 1000);
    }

    public void stop() {
        timer.cancel();
        System.out.println("Pomodoro timer stopped.");
    }
}
