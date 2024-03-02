package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.solutionsproject.R;
import com.example.solutionsproject.classes.PomodoroTimer;

public class PomodoroActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pomodoro);

		final PomodoroTimer[] ptc = new PomodoroTimer[1];
		final boolean[] hasStarted = {false};

		Button p_btn_close = findViewById(R.id.p_btn_close);
		Button p_btn_start = findViewById(R.id.p_btn_start);
		EditText p_nt_work = findViewById(R.id.p_nt_work);
		EditText p_nt_long = findViewById(R.id.p_nt_longbreak);
		EditText p_nt_break = findViewById(R.id.p_nt_break);
		EditText p_nt_longbreakinterval = findViewById(R.id.p_nt_longbreakinterval);

	
		
		//custom code goes here
		p_btn_close.setOnClickListener(v -> startActivity(new Intent(PomodoroActivity.this, CourseDetailsActivity.class)));

		//timer
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
	
	