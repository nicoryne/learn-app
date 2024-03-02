package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class home_activity extends Activity {

		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		ImageView search = findViewById(R.id.search);
		ImageView course = findViewById(R.id.course);
		ImageView message = findViewById(R.id.message);
		ImageView account = findViewById(R.id.account);
		ImageView profile = findViewById(R.id.profile);

		//custom code goes here
		profile.setOnClickListener(v -> startActivity(new Intent(home_activity.this, account_activity.class)));

		search.setOnClickListener(v -> Toast.makeText(home_activity.this, "search placeholder", Toast.LENGTH_SHORT).show());

		//footer nav
		account.setOnClickListener(v -> startActivity(new Intent(home_activity.this, account_activity.class)));

		course.setOnClickListener(v -> startActivity(new Intent(home_activity.this, courses_activity.class)));

		message.setOnClickListener(v -> startActivity(new Intent(home_activity.this, message_3_activity.class)));
	}
}
	
	