package com.example.solutionsproject.classes.general;

import static com.example.solutionsproject.activities.CourseDetailsActivity.KEY_BREAK_INTERVAL;
import static com.example.solutionsproject.activities.CourseDetailsActivity.KEY_BREAK_TIME;
import static com.example.solutionsproject.activities.CourseDetailsActivity.KEY_LONG_BREAK_TIME;
import static com.example.solutionsproject.activities.CourseDetailsActivity.KEY_WORK_TIME;
import static com.example.solutionsproject.activities.CourseDetailsActivity.PREF_NAME;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.solutionsproject.R;
import com.example.solutionsproject.activities.FlashcardActivity;

public class PomodoroService extends Service {
    private int workDuration; //preferences.getInt(KEY_WORK_TIME, 25) * 60 * 1000;
    private int shortBreakDuration;//preferences.getInt(KEY_BREAK_TIME, 5) * 60 * 1000;
    private int longBreakDuration;//preferences.getInt(KEY_LONG_BREAK_TIME, 30) * 60 * 1000;
    private int longBreakInterval;//preferences.getInt(KEY_BREAK_INTERVAL, 4) * 60 * 1000;

    private CountDownTimer timer;
    private int ctr;
    private int currentPhase; // 0 - Pomodoro, 1 - Short Break, 2 - Long Break
    private int remainingTime;

    private  Vibrator vibrator;

    @Override
    public void onCreate() {
        super.onCreate();

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        workDuration = preferences.getInt(KEY_WORK_TIME, 25) * 60 * 1000;
        shortBreakDuration = preferences.getInt(KEY_BREAK_TIME, 5) * 60 * 1000;
        longBreakDuration = preferences.getInt(KEY_LONG_BREAK_TIME, 30) * 60 * 1000;
        longBreakInterval = preferences.getInt(KEY_BREAK_INTERVAL, 4);

        ctr = 0;
        currentPhase = 0;
        remainingTime = workDuration;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startTimer();
        showNotification();
        return START_STICKY; // Re-create the service if needed
    }

    private void startTimer() {
        timer = new CountDownTimer(remainingTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingTime = (int) millisUntilFinished;
                updateNotification();
            }

            @Override
            public void onFinish() {
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                switch (currentPhase) {
                    case 0: // Pomodoro finished, start short break
                        ctr++;
                        currentPhase = 1;
                        remainingTime = workDuration;
                        break;
                    case 1: // Short break finished, start pomodoro again
                        currentPhase = 0;
                        remainingTime = shortBreakDuration;
                        break;
                    case 2: // Long break finished, reset timer
                        currentPhase = 0;
                        remainingTime = longBreakDuration;
                        break;
                }
                startTimer();
            }
        };
        timer.start();
    }

    @SuppressLint("ForegroundServiceType")
    private void showNotification() {
        String title, content;
        switch (currentPhase) {
            case 0:
                if(ctr > longBreakInterval){
                    currentPhase = 2;
                    ctr = 0;
                }
                title = "Pomodoro";
                content = "Focus for " + formatTime(remainingTime);
                break;
            case 1:
                title = "Short Break";
                content = "Take a short break: " + formatTime(remainingTime);
                break;
            case 2:
                title = "Long Break";
                content = "Take a longer break: " + formatTime(remainingTime);
                break;
            default:
                title = "Pomodoro Timer";
                content = "";
                break;
        }

        Intent notificationIntent = new Intent(this, FlashcardActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_MUTABLE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.stopwatch)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
    }

    private void updateNotification() {
        showNotification();
    }

    private String formatTime(int milliseconds) {
        int seconds = milliseconds / 1000;
        int minutes = seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Replace with your actual channel ID
    private static final String CHANNEL_ID = "TimerChannel";

    // Implement other methods like onBind and onUnbind (optional)
}
