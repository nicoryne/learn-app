package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class NotificationsActivity extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_notifications);

            TextView message = findViewById(R.id.message);
            ImageView search = findViewById(R.id.search);
            ImageView home = findViewById(R.id.home);
            ImageView course = findViewById(R.id.course);
            ImageView account = findViewById(R.id.account);


            //custom code goes here
            message.setOnClickListener(v -> startActivity(new Intent(NotificationsActivity.this, MessagesActivity.class)));

            //footer nav
            account.setOnClickListener(v -> startActivity(new Intent(NotificationsActivity.this, AccountActivity.class)));

            search.setOnClickListener(v -> Toast.makeText(NotificationsActivity.this, "search placeholder", Toast.LENGTH_SHORT).show());

            course.setOnClickListener(v -> startActivity(new Intent(NotificationsActivity.this, CoursesActivity.class)));

            home.setOnClickListener(v -> startActivity(new Intent(NotificationsActivity.this, HomeActivity.class)));
        }
    }
	
	