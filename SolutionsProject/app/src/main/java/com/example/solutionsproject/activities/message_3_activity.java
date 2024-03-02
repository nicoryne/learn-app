package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class message_3_activity extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.message_3);

            TextView message = findViewById(R.id.message);
            ImageView search = findViewById(R.id.search);
            ImageView home = findViewById(R.id.home);
            ImageView course = findViewById(R.id.course);
            ImageView account = findViewById(R.id.account);


            //custom code goes here
            message.setOnClickListener(v -> startActivity(new Intent(message_3_activity.this, message_4_activity.class)));

            //footer nav
            account.setOnClickListener(v -> startActivity(new Intent(message_3_activity.this, account_activity.class)));

            search.setOnClickListener(v -> Toast.makeText(message_3_activity.this, "search placeholder", Toast.LENGTH_SHORT).show());

            course.setOnClickListener(v -> startActivity(new Intent(message_3_activity.this, courses_activity.class)));

            home.setOnClickListener(v -> startActivity(new Intent(message_3_activity.this, home_activity.class)));
        }
    }
	
	