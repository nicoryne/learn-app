package com.example.solutionsproject.activities;

import static com.example.solutionsproject.classes.general.PomodoroTimer.break_;
import static com.example.solutionsproject.classes.general.PomodoroTimer.break_interval;
import static com.example.solutionsproject.classes.general.PomodoroTimer.long_;
import static com.example.solutionsproject.classes.general.PomodoroTimer.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.solutionsproject.R;
import com.example.solutionsproject.classes.general.PomodoroTimer;

import org.ini4j.Ini;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CourseDetailsActivity extends Activity {

        @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        ImageView button_primary__background_ = findViewById(R.id.button_primary__background_);
        ImageView button_secondary__background_ = findViewById(R.id.button_secondary__background_);
        ImageView vector_3 = findViewById(R.id.vector_3);
        ImageView cd_btn_pomodoro = findViewById(R.id.cd_btn_pomodoro);
        ConstraintLayout main_view = findViewById(R.id.mask_group_14);

        //custom code goes here
        button_primary__background_.setOnClickListener(v -> {
            startActivity(new Intent(CourseDetailsActivity.this, FlashcardActivity.class));
            //PopupTimer(main_view);
        });
        button_secondary__background_.setOnClickListener(v -> Toast.makeText(CourseDetailsActivity.this, "favorite placeholder", Toast.LENGTH_SHORT).show());

        //back button
        vector_3.setOnClickListener(v -> startActivity(new Intent(CourseDetailsActivity.this, CoursesActivity.class)));

        //pomodoro button
        cd_btn_pomodoro.setOnClickListener(v -> PopupPomodoro(main_view));
    }
        public void PopupPomodoro(View view) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.activity_pomodoro, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
            boolean focusable = true;
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            // pomodoro fields
            Button p_btn_close = popupView.findViewById(R.id.p_btn_close);
            Button p_btn_save = popupView.findViewById(R.id.p_btn_save);
            EditText p_nt_work = popupView.findViewById(R.id.p_nt_work);
            EditText p_nt_long = popupView.findViewById(R.id.p_nt_longbreak);
            EditText p_nt_break = popupView.findViewById(R.id.p_nt_break);
            EditText p_nt_longbreakinterval = popupView.findViewById(R.id.p_nt_longbreakinterval);

            // INI FILE READING DOES NOT WORK YET
//            Ini aRead = new Ini();
//            File hi = new File("IniConfigs/TimerConfig.ini");
//            System.out.println(hi.getAbsolutePath());
//            try {
//                aRead.load(new FileReader(hi.getAbsolutePath()));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            int work = aRead.get("timer", "work", int.class);
//            int break_ = aRead.get("timer", "break", int.class);
//            int long_ = aRead.get("timer", "long", int.class);
//            int longbreakinterval = aRead.get("timer", "break_interval", int.class);

            p_nt_work.setText("" + work);
            p_nt_break.setText("" + break_);
            p_nt_long.setText("" + long_);
            p_nt_longbreakinterval.setText("" + break_interval);

            // pomodoro methods
            p_btn_close.setOnClickListener(v -> popupWindow.dismiss());
            p_btn_save.setOnClickListener(v -> {
                work = Integer.parseInt(String.valueOf(p_nt_work.getText()));
                break_ = Integer.parseInt(String.valueOf(p_nt_break.getText()));
                long_ = Integer.parseInt(String.valueOf(p_nt_long.getText()));
                break_interval = Integer.parseInt(String.valueOf(p_nt_longbreakinterval.getText()));
            });

        }

    public void PopupTimer(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_timer, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(view, Gravity.TOP, 0, 0);

        //pomodoro functionalities
        final PomodoroTimer[] ptc = new PomodoroTimer[1];
        final boolean[] hasStarted = {false};

        Button t_btn_close = popupView.findViewById(R.id.t_btn_close);
        TextView t_tv_longbreak = popupView.findViewById(R.id.t_tv_longbreak);
        TextView t_tv_timer_clock = popupView.findViewById(R.id.t_tv_timer_clock);

        t_btn_close.setOnClickListener(v -> popupWindow.dismiss());
        ptc[0] = new PomodoroTimer(work, break_, long_, break_interval, t_tv_timer_clock, t_tv_longbreak);
        if(hasStarted[0]){
            ptc[0].stop();
             hasStarted[0] = false;
        }else{
            ptc[0].start();
            hasStarted[0] = true;
        }

        popupView.setOnTouchListener(new View.OnTouchListener() {
            private int dx = 0;
            private int dy = 0;
            private int mPosX = 0;
            private int mPosY = 0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = (int) (mPosX - motionEvent.getRawX());
                        dy = (int) (mPosY - motionEvent.getRawY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mPosX = (int) (motionEvent.getRawX() + dx);
                        mPosY = (int) (motionEvent.getRawY() + dy);
                        popupWindow.update(mPosX, mPosY, -1, -1);
                        break;
                }
                return true;
            }
        });
    }
}