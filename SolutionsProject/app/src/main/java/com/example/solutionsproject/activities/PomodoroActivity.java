package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.solutionsproject.R;

public class PomodoroActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pomodoro);


		Button p_btn_close = findViewById(R.id.p_btn_close);
		
		//custom code goes here
		p_btn_close.setOnClickListener(v -> startActivity(new Intent(PomodoroActivity.this, CourseDetailsActivity.class)));
	}
}
	
	