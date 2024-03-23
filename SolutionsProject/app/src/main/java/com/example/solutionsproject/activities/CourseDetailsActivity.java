package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.solutionsproject.R;

public class CourseDetailsActivity extends Activity {

    public static final String PREF_NAME = "PomodoroPrefs";
    public static final String KEY_WORK_TIME = "work_time_minutes";
    public static final String KEY_BREAK_TIME = "break_time_minutes";
    public static final String KEY_LONG_BREAK_TIME = "long_break_time_minutes";
    public static final String KEY_BREAK_INTERVAL = "break_time_interval";
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
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Button p_btn_close = popupView.findViewById(R.id.p_btn_close);
        Button p_btn_save = popupView.findViewById(R.id.p_btn_save);
        EditText p_nt_work = popupView.findViewById(R.id.p_nt_work);
        EditText p_nt_long = popupView.findViewById(R.id.p_nt_longbreak);
        EditText p_nt_break = popupView.findViewById(R.id.p_nt_break);
        EditText p_nt_longbreakinterval = popupView.findViewById(R.id.p_nt_longbreakinterval);

        p_nt_work.setText(String.valueOf(preferences.getInt(KEY_WORK_TIME, 25)));
        p_nt_break.setText(String.valueOf(preferences.getInt(KEY_BREAK_TIME, 5)));
        p_nt_long.setText(String.valueOf(preferences.getInt(KEY_LONG_BREAK_TIME, 30)));
        p_nt_longbreakinterval.setText(String.valueOf(preferences.getInt(KEY_BREAK_INTERVAL, 4)));

//        // pomodoro methods
        p_btn_close.setOnClickListener(v -> popupWindow.dismiss());
        p_btn_save.setOnClickListener(v -> {
            int work = Integer.parseInt(String.valueOf(p_nt_work.getText()));
            editor.putInt(KEY_WORK_TIME, work);
            int break_ = Integer.parseInt(String.valueOf(p_nt_break.getText()));
            editor.putInt(KEY_BREAK_TIME, break_);
            int long_ = Integer.parseInt(String.valueOf(p_nt_long.getText()));
            editor.putInt(KEY_LONG_BREAK_TIME, long_);
            int break_interval = Integer.parseInt(String.valueOf(p_nt_longbreakinterval.getText()));
            editor.putInt(KEY_BREAK_INTERVAL, break_interval);
            editor.apply();
        });
    }
}