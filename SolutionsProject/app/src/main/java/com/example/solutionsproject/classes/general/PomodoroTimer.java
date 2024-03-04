package com.example.solutionsproject.classes.general;

import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private Timer timer;
    private boolean isWorkTime;
    private int work;
    private int break_;
    private int long_;
    private int break_interval;
    private int interval_ctr;

    public PomodoroTimer(int work, int break_, int long_, int break_interval) {
        this.work = work;
        this.break_ = break_;
        this.long_ = long_;
        this.break_interval = break_interval;

        timer = new Timer();
        isWorkTime = true;
    }

    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (isWorkTime) {
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
                }
            }
        };

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
