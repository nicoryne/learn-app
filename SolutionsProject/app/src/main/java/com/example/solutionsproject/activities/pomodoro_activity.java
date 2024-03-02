
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		frame_14
	 *	@date 		Thursday 29th of February 2024 12:23:46 PM
	 *	@title 		Page 2
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.solutionsproject.activities;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.TextView;

	import com.example.solutionsproject.R;
	import com.example.solutionsproject.classes.PomodoroTimer;

	public class pomodoro_activity extends Activity {

	
	private View _bg__frame_14;
	private View _bg__overlay_ek1;
	private View _bg__bg_ek1;
	private ImageView bg_ek2;
	private View _bg__alarm_ek1;
	private TextView timer;
	private ImageView slder_1;
	private ImageView background;
	private View _bg__frame_13_ek1;
	private TextView door_bell;
	private ImageView dropdown;
	private View _bg__timer_minutes__ek1;
	private View _bg__break_interval_ek1;
	private ImageView background_ek1;
	private View _bg__frame_13_ek3;
	private TextView _4;
	private TextView timer_ek1;
	private View _bg__timersetter_ek1;
	private View _bg__work_ek1;
	private ImageView background_ek2;
	private View _bg__frame_13_ek5;
	private TextView _25;
	private TextView timer_ek2;
	private View _bg__break_ek1;
	private ImageView background_ek3;
	private View _bg__frame_13_ek7;
	private TextView _5;
	private TextView timer_ek3;
	private View _bg__long_break_ek1;
	private ImageView background_ek4;
	private View _bg__frame_13_ek9;
	private TextView _20;
	private TextView timer_ek4;
	private View _bg__text_ek1;
	private TextView timer_ek5;
	private TextView pomodoro_timer;
	private View _bg__progressbar_ek1;
	private View _bg__text_ek3;
	private TextView progress_;
	private View _bg__text_ek5;
	private TextView long_break_ek2;
	private View _bg__recorder_ek1;
	private View _bg__recorder_ek3;
	private View _bg__group_9_ek1;
	private ImageView ellipse_20;
	private TextView _1;
	private View _bg__group_9_ek3;
	private ImageView ellipse_20_ek1;
	private TextView _2;
	private View _bg__group_9_ek5;
	private ImageView ellipse_20_ek2;
	private TextView _3;
	private View _bg__group_9_ek7;
	private ImageView ellipse_20_ek3;
	private TextView _4_ek1;
	private View _bg__group_9_ek9;
	private ImageView ellipse_20_ek4;
	private TextView _5_ek1;
	private View _bg__group_9_ek11;
	private ImageView ellipse_20_ek5;
	private TextView _6;
	private View _bg__group_9_ek13;
	private ImageView ellipse_20_ek6;
	private TextView _7;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.pomodoro);

		final PomodoroTimer[] ptc = new PomodoroTimer[1];
		final boolean[] hasStarted = {false};
		
		_bg__frame_14 = (View) findViewById(R.id._bg__frame_14);
		_bg__overlay_ek1 = (View) findViewById(R.id._bg__overlay_ek1);
		_bg__bg_ek1 = (View) findViewById(R.id._bg__bg_ek1);
		bg_ek2 = (ImageView) findViewById(R.id.bg_ek2);
		timer = (TextView) findViewById(R.id.timer);
		slder_1 = (ImageView) findViewById(R.id.slder_1);
		background = (ImageView) findViewById(R.id.background);
		door_bell = (TextView) findViewById(R.id.door_bell);
		_bg__break_interval_ek1 = (View) findViewById(R.id._bg__break_interval_ek1);
		background_ek1 = (ImageView) findViewById(R.id.background_ek1);
		_bg__frame_13_ek3 = (View) findViewById(R.id._bg__frame_13_ek3);
		timer_ek1 = (TextView) findViewById(R.id.timer_ek1);
		background_ek2 = (ImageView) findViewById(R.id.background_ek2);
		timer_ek2 = (TextView) findViewById(R.id.timer_ek2);
		background_ek3 = (ImageView) findViewById(R.id.background_ek3);
		_bg__frame_13_ek7 = (View) findViewById(R.id._bg__frame_13_ek7);
		timer_ek3 = (TextView) findViewById(R.id.timer_ek3);
		background_ek4 = (ImageView) findViewById(R.id.background_ek4);
		timer_ek4 = (TextView) findViewById(R.id.timer_ek4);
		timer_ek5 = (TextView) findViewById(R.id.timer_ek5);
		pomodoro_timer = (TextView) findViewById(R.id.pomodoro_timer);
		Button p_btn_close = findViewById(R.id.p_btn_close);
		Button p_btn_start = findViewById(R.id.p_btn_start);
		EditText p_nt_work = findViewById(R.id.p_nt_work);
		EditText p_nt_long = findViewById(R.id.p_nt_longbreak);
		EditText p_nt_break = findViewById(R.id.p_nt_break);
		EditText p_nt_longbreakinterval = findViewById(R.id.p_nt_longbreakinterval);

	
		
		//custom code goes here
		p_btn_close.setOnClickListener(v -> startActivity(new Intent(pomodoro_activity.this, course_details_activity.class)));

		//timer
		p_btn_start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
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

			}
		});
	}
}
	
	