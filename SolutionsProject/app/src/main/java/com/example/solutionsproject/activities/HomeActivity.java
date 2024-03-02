package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class HomeActivity extends Activity {

		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		ImageView search = findViewById(R.id.search);
		ImageView course = findViewById(R.id.course);
		ImageView message = findViewById(R.id.message);
		ImageView account = findViewById(R.id.account);
		ImageView profile = findViewById(R.id.profile);

		//custom code goes here
		profile.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AccountActivity.class)));

		search.setOnClickListener(v -> Toast.makeText(HomeActivity.this, "search placeholder", Toast.LENGTH_SHORT).show());

		//footer nav
		account.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AccountActivity.class)));

		course.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, CoursesActivity.class)));

		message.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, NotificationsActivity.class)));
	}
}
	
	