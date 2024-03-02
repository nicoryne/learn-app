package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class MessagesActivity extends Activity {
    @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_messages);

            TextView notification = (TextView) findViewById(R.id.notification);
            ImageView search = (ImageView) findViewById(R.id.search);
            ImageView home = (ImageView) findViewById(R.id.home);
            ImageView course = (ImageView) findViewById(R.id.course);
            ImageView account = (ImageView) findViewById(R.id.account);


            //custom code goes here
            notification.setOnClickListener(v -> startActivity(new Intent(MessagesActivity.this, NotificationsActivity.class)));

            search.setOnClickListener(v -> Toast.makeText(MessagesActivity.this, "search placeholder", Toast.LENGTH_SHORT).show());

            //footer nav
            account.setOnClickListener(v -> startActivity(new Intent(MessagesActivity.this, AccountActivity.class)));

            course.setOnClickListener(v -> startActivity(new Intent(MessagesActivity.this, CoursesActivity.class)));

            home.setOnClickListener(v -> startActivity(new Intent(MessagesActivity.this, HomeActivity.class)));
        }
    }
	
	