package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
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
import com.example.solutionsproject.classes.PomodoroTimer;

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
        button_primary__background_.setOnClickListener(v -> Toast.makeText(CourseDetailsActivity.this, "learn now placeholder", Toast.LENGTH_SHORT).show());
        button_secondary__background_.setOnClickListener(v -> Toast.makeText(CourseDetailsActivity.this, "favorite placeholder", Toast.LENGTH_SHORT).show());

        //back button
        vector_3.setOnClickListener(v -> startActivity(new Intent(CourseDetailsActivity.this, CoursesActivity.class)));

        //pomodoro button
        cd_btn_pomodoro.setOnClickListener(v -> onButtonShowPopupWindowClick(main_view));
    }
        public void onButtonShowPopupWindowClick(View view) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.activity_pomodoro, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true;
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            //pomodoro functionalities
            final PomodoroTimer[] ptc = new PomodoroTimer[1];
            final boolean[] hasStarted = {false};

            Button p_btn_close = popupView.findViewById(R.id.p_btn_close);
            Button p_btn_start = popupView.findViewById(R.id.p_btn_start);
            EditText p_nt_work = popupView.findViewById(R.id.p_nt_work);
            EditText p_nt_long = popupView.findViewById(R.id.p_nt_longbreak);
            EditText p_nt_break = popupView.findViewById(R.id.p_nt_break);
            EditText p_nt_longbreakinterval = popupView.findViewById(R.id.p_nt_longbreakinterval);

            p_btn_close.setOnClickListener(v -> popupWindow.dismiss());
            p_btn_start.setOnClickListener(v -> {
                int work = Integer.parseInt(String.valueOf(p_nt_work.getText()));
                int break_ = Integer.parseInt(String.valueOf(p_nt_break.getText()));
                int long_ = Integer.parseInt(String.valueOf(p_nt_long.getText()));
                int longbreakinterval = Integer.parseInt(String.valueOf(p_nt_longbreakinterval.getText()));

                ptc[0] = new PomodoroTimer(work, break_, long_, longbreakinterval);
                if(hasStarted[0]){
                    p_btn_start.setText("start");
                    ptc[0].stop();
                    hasStarted[0] = false;
                }else{
                    p_btn_start.setText("stop");
                    ptc[0].start();
                    hasStarted[0] = true;
                }
            });
        }
}
	
	