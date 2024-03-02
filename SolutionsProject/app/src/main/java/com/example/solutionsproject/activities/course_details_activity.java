package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class course_details_activity extends Activity {

        @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_details);

        ImageView button_primary__background_ = findViewById(R.id.button_primary__background_);
        ImageView button_secondary__background_ = findViewById(R.id.button_secondary__background_);
        ImageView vector_3 = findViewById(R.id.vector_3);
        ImageView cd_btn_pomodoro = findViewById(R.id.cd_btn_pomodoro);
        ScrollView course_details = findViewById(R.id.course_details);


        //custom code goes here
        button_primary__background_.setOnClickListener(v -> Toast.makeText(course_details_activity.this, "learn now placeholder", Toast.LENGTH_SHORT).show());

        button_secondary__background_.setOnClickListener(v -> Toast.makeText(course_details_activity.this, "favorite placeholder", Toast.LENGTH_SHORT).show());

        //back button
        vector_3.setOnClickListener(v -> startActivity(new Intent(course_details_activity.this, courses_activity.class)));

        //pomodoro button (window pop up, but buttons don't work)
        //cd_btn_pomodoro.setOnClickListener(v -> onButtonShowPopupWindowClick(course_details));
        cd_btn_pomodoro.setOnClickListener(v -> startActivity(new Intent(course_details_activity.this, pomodoro_activity.class)));
    }
        public void onButtonShowPopupWindowClick(View view) {

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.pomodoro, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            // dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }
}
	
	